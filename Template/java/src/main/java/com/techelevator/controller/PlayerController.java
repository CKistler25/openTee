package com.techelevator.controller;


import com.techelevator.dao.PlayerDAO;
import com.techelevator.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    private PlayerDAO dao;

    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    @RequestMapping(path = "/heartbeat", method= RequestMethod.GET)
    public String heartbeat () {
        return "deh-dump!";
    }

    @RequestMapping(path = "/players", method= RequestMethod.GET)
    public List<Player> fetchAllPlayers() {
        return dao.fetchAllPLayers();
    }

    @RequestMapping(path = "/players/{id}", method= RequestMethod.GET)
    public Player fetchPlayerById(@PathVariable int id) {
        Player foundPlayer = dao.fetchPlayerByPlayerId(id);
        if (foundPlayer == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return foundPlayer;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/players", method= RequestMethod.POST)
    public Player addNewPlayer(@Valid @RequestBody Player newPlayer) {
        return dao.addPLayer(newPlayer);
    }


    @RequestMapping(path = "/players", method= RequestMethod.PUT)
    public Player updatePlayer(@Valid @RequestBody Player updatedPlayer) {
        return dao.updatePlayer(updatedPlayer);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/players/{id}", method= RequestMethod.DELETE)
    public void deletePLayer(@PathVariable int id) {

        if (dao.fetchPlayerByPlayerId(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        dao.deletePlayer(id);
    }

}
