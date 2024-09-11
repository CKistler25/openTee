package com.techelevator.controller;


import com.techelevator.dao.TeeTimeDao;
import com.techelevator.model.TeeTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("permitAll()")
public class TeeTimeController {

    @Autowired
    private TeeTimeDao dao;

    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    @RequestMapping(path = "/heartbeat", method= RequestMethod.GET)
    public String heartbeat () {
        return "deh-dump!";
    }

    @GetMapping(path = "/times/{date}")
    public List<TeeTime> fetchAllTimes(@PathVariable("date") String date) {
        return dao.fetchAllTeeTimes(date);
    }
//
//    @RequestMapping(path = "/players/{id}", method= RequestMethod.GET)
//    public TeeTime fetchPlayerById(@PathVariable int id) {
//        TeeTime foundTeeTime = dao.fetchPlayerByPlayerId(id);
//        if (foundTeeTime == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
//        return foundTeeTime;
//    }
//
//    @ResponseStatus(HttpStatus.CREATED)
//    @RequestMapping(path = "/players", method= RequestMethod.POST)
//    public TeeTime addNewPlayer(@Valid @RequestBody TeeTime newTeeTime) {
//        return dao.addPLayer(newTeeTime);
//    }
//
//
//    @RequestMapping(path = "/players", method= RequestMethod.PUT)
//    public TeeTime updatePlayer(@Valid @RequestBody TeeTime updatedTeeTime) {
//        return dao.updatePlayer(updatedTeeTime);
//    }
//
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @RequestMapping(path = "/players/{id}", method= RequestMethod.DELETE)
//    public void deletePLayer(@PathVariable int id) {
//
//        if (dao.fetchPlayerByPlayerId(id) == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
//        dao.deletePlayer(id);
//    }

}
