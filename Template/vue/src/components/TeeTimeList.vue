<template>
    <div class="main">
      <label for="datePicker">Select a Date to Search Tee Times: </label>
      <input type="date" id="datePicker" v-model="dateSelector">
      <button v-on:click="getTeeTimes" v-show="showButton">Get Tee Times</button>
      <PageLoader v-show="loaded == false"/>  
      <!-- Sort Options as clickable links -->
      
  
      <!-- Display sorted tee times as cards in grid -->
      <div class="grid-container">
        <div class="teeTimeContainer" v-for="teeTime in sortedTeeTimes" :key="teeTime.time">
          <a v-bind:href="teeTime.bookingUrl" target="_blank">
          <div class="card" >
            <div class="time">{{ teeTime.time }}</div>
            <div class="course-name">{{ teeTime.courseName }}</div>
            <div class="holes">{{ teeTime.holes }} holes</div>
            <div class="price">{{ teeTime.price }}</div>
          </div>
        </a>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import TeeTimeService from "../services/TeeTimeService";
  import PageLoader from "./PageLoader.vue";
  
  export default {
    components:{
      PageLoader
    },
    data() {
      return {
        teeTimes: [], // Array to hold fetched tee times
        showButton: true, // Flag to show or hide the button
        sortOption: "earliest", // Default sorting option
        loaded: true,
        dateSelector: "",
      };
    },
    methods: {
      // Fetch tee times from the service
      getTeeTimes() {
        this.showButton = false;
        this.loaded = false;
        TeeTimeService.fetchAllTeeTimes(this.dateSelector)
          .then((response) => {
            this.teeTimes = [...response.data];
            this.loaded = true;
          })
          .catch((error) => {
            console.log(error);
          });
      },
      convertTimeToDate(timeStr) {
        const [time, modifier] = timeStr.split(/(am|pm)/);
        let [hours, minutes] = time.split(':').map(Number);
  
        if (modifier === 'pm' && hours < 12) hours += 12;
        if (modifier === 'am' && hours === 12) hours = 0;
  
        return new Date(1970, 0, 1, hours, minutes); // Date object for comparison
      },
      sortBookingsByTime() {
        return this.teeTimes.sort((a, b) => this.convertTimeToDate(a.time) - this.convertTimeToDate(b.time));
      }
    },
    computed: {
      // Computed property for sorting tee times reactively
      sortedTeeTimes() {
        return this.sortBookingsByTime(); // Return the sorted array
      }
    },
    mounted() {
    document.onreadystatechange = () => {
      if (document.readyState == "complete") {
        this.loaded = true;
      }
    }
  },
  };
  </script>

<style scoped>

/* General Styles */
.body {
    display: flex;
    background-color: #f4f4f9;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    justify-content: center;
    text-align: center;
}

.main {
    display: flex;
    flex-direction: column; /* Align items vertically */
    justify-content: center; /* Center items horizontally */
    align-items: center; /* Center items vertically */
    width: 80%;
    text-align: center; /* Center text within the button */
}

/* TeeTime Card Grid */
.grid-container {
    display: grid;
    max-width: 80%;
    grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
    gap: 1rem;
    justify-items: center;
    justify-content: space-around;
    padding: 1rem 0;
}

/* Card Styles */
.card {
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    padding: 1rem;
    width: 100px; /* Fixed width for card */
    height: 150px; /* Fixed height for card */
    text-align: center;
    transition: transform 0.2s ease;
    display: flex;
    flex-direction: column;
    justify-content: space-between; /* Distributes content evenly */
}

.card:hover {
    transform: translateY(-5px);
}

.time, .course-name, .holes, .price {
    margin-bottom: 0.5rem;
}

.time {
    font-weight: bold;
    font-size: 1.2rem;
}

.course-name {
    color: #007bff;
    font-size: large;
    font-weight: 800;
}

.price {
    color: #28a745;
    font-weight: bold;
    font-size: 1.2rem;
}




</style>  