<template>
  <header>
    <nav class="navbar navbar-light bg-light">
      <div class="container-fluid">
        <a class="navbar-brand logo-head" href="#">
          <img
            src="https://res.cloudinary.com/drtlz85pc/image/upload/v1726071936/Screen_Shot_2024-09-11_at_10.01.22_AM_ums3bu.png"
            alt=""
            width="40"
            height="32"
            class="d-inline-block align-text-top"
          />
          <div class="brand-name-text">OpenTee</div>
        </a>
        <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
    </div>
      </div>
      
      
    </nav>

    

    

    <!-- <router-link id="LoginLink" v-bind:to="{ name: 'login' }">Login |</router-link> -->
    <!-- <router-link id="LoginLink" v-bind:to="{ name: 'logout' }"> Logout</router-link> -->
  </header>
</template>

<script>
export default {
  // test

  methods: {
    logout() {
      this.$store.commit("LOGOUT");
      this.$router.push("/");
    },
    goHome() {
      this.$router.push("/");
    },
    // test
  },
};
</script>

<style scoped>
/* Apply a professional font  */
@import url("https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap");

.logo-head{
  display: flex;
  flex-flow: row;
}
.brand-name-text{
  padding-left: 1rem;
}


</style>