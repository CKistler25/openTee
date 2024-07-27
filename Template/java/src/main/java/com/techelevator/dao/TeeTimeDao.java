package com.techelevator.dao;


import com.techelevator.model.TeeTime;

import java.util.List;

public interface TeeTimeDao {

        public List<TeeTime> fetchAllTeeTimes();

        public TeeTime fetchPlayerByPlayerId(int playerId);

        public TeeTime addPLayer(TeeTime newTeeTime);

        public TeeTime updatePlayer(TeeTime updatedTeeTime);

        public void deletePlayer(int playerId);

}
