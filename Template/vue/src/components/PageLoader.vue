<template>
  <div class="page-loader" v-if="!isloaded">
    <div class="gif">
      <img src="/public/swing-silhouette.gif">
      <div class="loader-container">
      <div class="loader">
        <div></div>
        <div></div>
        <div></div>
      </div>
      
    </div>
    <div class="loading-text">
        Loading Tee Times
      </div>
    </div>
    
   
  </div>
</template>

<script>
export default {
  data: () => {
    return {
      isloaded: false
    }
  },
  mounted() {
    document.onreadystatechange = () => {
      if (document.readyState == "complete") {
        this.isloaded = true;
      }
    }
  },
}
</script>

<style scoped>
.page-loader {
  display: flex;
  justify-content: center;
  align-items: center;
  position: fixed;
  top: 0;
  left: 0;
  width: 100vw;
  height: 100%;
  background-color: #387f0896;
  z-index: 999;
}
.loader-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 10vh;
}

.loading-text{
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  font-weight: 500;
  font-size: larger;
}
.loader {
  display: flex;
  justify-content: space-between;
  width: 80px;
}

.loader div {
  width: 16px;
  height: 16px;
  background-color: #808080;
  border-radius: 50%;
  animation: grow-shrink 1.5s infinite;
}

.loader div:nth-child(1) {
  animation-delay: 0s;
}

.loader div:nth-child(2) {
  animation-delay: 0.3s;
}

.loader div:nth-child(3) {
  animation-delay: 0.6s;
}

@keyframes grow-shrink {
  0%, 100% {
    transform: scale(1);
  }
  50% {
    transform: scale(1.5);
  }
}
</style>