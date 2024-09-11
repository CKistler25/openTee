package com.opentee.dao;


import com.opentee.model.TeeTime;

import java.util.List;

public interface TeeTimeDao {

        public List<TeeTime> fetchAllTeeTimes(String date);

        

}
