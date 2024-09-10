<template>
  <div class="home">
    <h1>Home</h1>
    <TeeTimeList />
  </div>
</template>

<script>

import TeeTimeList from '../components/TeeTimeList.vue';

export default {
  data(){


},
components:{
  TeeTimeList
}


};
</script>
<style>

.home{
  display: flex;
  flex-flow: column;
  justify-content: center;
  text-align: center;
}

h1{
  text-align: center;
}





</style>
