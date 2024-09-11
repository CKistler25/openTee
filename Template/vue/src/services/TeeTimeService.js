import axios from 'axios';

export default {

  fetchAllTeeTimes(date){
    return axios.get(`/times/${date}`);
  },

}