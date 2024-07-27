package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Player;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPlayerDao implements PlayerDAO{

    private final JdbcTemplate jdbcTemplate;

    public JdbcPlayerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Player> fetchAllPLayers() {

        List<Player> players = new ArrayList<>();
        String sql = "SELECT player_id, firstname, lastname, jerseynumber, salary, team_id, image_url FROM players";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while  (results.next()) {
                Player player = mapRowToPlayer(results);

                //this calls private method below to retrieve List<String> positions. Broke out so I can reuse later
                player.setPositions(retrievePositions(player.getPlayerId()));

                players.add(player);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return players;
    }

    @Override
    public Player fetchPlayerByPlayerId(int playerId) {

        Player player = null;
        String sql = "SELECT player_id, firstname, lastname, jerseynumber, salary, team_id, image_url FROM players " +
                     " WHERE player_id = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, playerId);

            if  (results.next()) {
                 player = mapRowToPlayer(results);

                //this calls private method below to retrieve List<String> positions. Broke out so I can reuse later
                player.setPositions(retrievePositions(player.getPlayerId()));

            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return player;
    }

    @Override
    public Player addPLayer(Player newPlayer) {

        //insert into players table
        String player_table_sql = "INSERT INTO players (firstname, lastname, jerseynumber, salary, team_id, image_url) VALUES (?, ?, ?, ?, ?, ?) RETURNING player_id";
        int new_id = jdbcTemplate.queryForObject(player_table_sql, int.class, newPlayer.getFirstName(), newPlayer.getLastName(), newPlayer.getJerseyNumber(), newPlayer.getSalary(), newPlayer.getTeamId(), newPlayer.getImageUrl());
        newPlayer.setPlayerId(new_id);

        //insert into positions table
        //TODO (Lot of work so skipping. We need to make sure the front end picks from a list )

        //insert into player_position table
        //TODO



        return newPlayer;
    }

    @Override
    public Player updatePlayer(Player updatedPlayer) {
        String sql = "UPDATE players SET firstname = ?, lastname = ?, jerseynumber = ?, salary = ?, team_id = ? " +
                     "WHERE player_id = ?";

        int rowCount = jdbcTemplate.update(sql, updatedPlayer.getFirstName(), updatedPlayer.getLastName(), updatedPlayer.getJerseyNumber(), updatedPlayer.getSalary(), updatedPlayer.getTeamId(), updatedPlayer.getPlayerId());

        if (rowCount < 1) {
            throw new DaoException("Error. Player was not updated.");
        }
        return updatedPlayer;
    }

    @Override
    public void deletePlayer(int playerId){

        //TODO Handle exceptions properly...

        // SQL TO REMOVE FROM JOIN TABLE AND PLAYER TABLE
        String sql2 = "DELETE FROM player_position WHERE player_id = ?";
        String sql3 = "DELETE FROM players WHERE player_id = ?";

        jdbcTemplate.update(sql2, playerId);
        jdbcTemplate.update(sql3, playerId);

    }



    private Player mapRowToPlayer(SqlRowSet rowSet) {
        Player player = new Player();
        player.setPlayerId(rowSet.getInt("player_id"));
        player.setFirstName(rowSet.getString("firstname"));
        player.setLastName(rowSet.getString("lastname"));
        player.setJerseyNumber(rowSet.getInt("jerseynumber"));
        player.setSalary(rowSet.getDouble("salary"));
        player.setTeamId(rowSet.getInt("team_id"));
        player.setImageUrl(rowSet.getString("image_url"));
        return player;
    }

    private List<String> retrievePositions(int playerId) {
        List<String> positions = new ArrayList<>();

        String sql = "SELECT positions.positionName FROM player_position " +
                "JOIN positions ON player_position.position_id = positions.position_id " +
                "WHERE player_id = ?";
        SqlRowSet pos_results = jdbcTemplate.queryForRowSet(sql, playerId);

        while (pos_results.next()) {
            positions.add(pos_results.getString("positionName"));
        }

        return positions;
    }

}
