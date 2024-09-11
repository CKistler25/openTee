<template>
  <div class="container">
    <the-header />
    <div class="content">
      <div class="listItems">
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
/* Set the container to be a flexbox and take the full viewport height */
.container {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
  min-width: 100vw; /* Ensures the container takes the full height of the viewport */
  padding: 0%;
}

/* Ensure the content takes up all available space between header and footer */
.content {
  flex: 1; /* This will push the footer to the bottom */
  display: flex;
  justify-content: center; /* Center the content horizontally if needed */
  align-items: flex-start; /* Align the content at the top */
}

.listItems {
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 100%;
}

the-footer {
  /* Optional footer styling */
  background-color: #f1f1f1;
  text-align: center;
  padding: 1rem;
  width: 100%;
  
}
</style>
