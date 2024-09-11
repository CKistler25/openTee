<template>
  <div>
  <the-header/>
  <div>
    
  <!-- <h1>Home</h1> -->
  <div class="list">
    <TeeTimeList />
  </div>
</div>
<the-footer />
</div>
</template>

<script>


import TeeTimeList from '../components/TeeTimeList.vue';
import TheHeader from '../components/TheHeader.vue';
import TheFooter from '../components/TheFooter.vue';

export default {
  data(){


},
components:{
  TeeTimeList,
  TheHeader,
  TheFooter,
  
}


};
</script>
<style scoped>
.list {
  display: flex;
  flex-direction: column; /* Center items vertically */
  align-items: center; /* Center items horizontally */
  justify-content: flex-start; /* Center items vertically */
  height: 100vh; /* Full viewport height */
  margin: 0; /* Remove default margin */
  padding: 0; /* Remove default padding if needed */
  box-sizing: border-box; /* Ensure padding/margin does not affect height */
}

h1 {
  margin: 0; /* Remove default margin */
  text-align: center;
}
</style>