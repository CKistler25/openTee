package com.techelevator.dao;


import com.techelevator.model.Player;

import java.util.List;

public interface PlayerDAO {

        public List<Player> fetchAllPLayers();

        public Player fetchPlayerByPlayerId(int playerId);

        public Player addPLayer(Player newPlayer);

        public Player updatePlayer(Player updatedPlayer);

        public void deletePlayer(int playerId);

}
