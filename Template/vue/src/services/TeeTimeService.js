import axios from 'axios';

export default {

  fetchAllTeeTimes(){
    return axios.get('/times');
  },

}
