<template>
    
    <footer class="footer-container">
      <div class="footer-content">
        <h3>Connect with Us</h3>
        <div class="social-icons">
          <a href="https://github.com/CKistler25" target="_blank" rel="noopener noreferrer">
            <i class="fa-brands fa-github fa-2xl"></i>
          </a>
          <a href="https://www.linkedin.com/in/carter-kistler/" target="_blank" rel="noopener noreferrer">
            <i class="fa-brands fa-linkedin fa-2xl"></i>
          </a>
        </div>
      </div>
      <div class="footer-bottom">
        <p>OpenTee © {{ currentYear }}</p>
      </div>
    </footer>
  </template>
  
  <script>
  export default {
    data() {
      return {
        currentYear: new Date().getFullYear(),
      };
    },
  };
  </script>
  
  <style scoped>
  .footer-container {
    background-color: #333;
    color: white;
    padding-top: .3rem;
    padding-bottom: .1rem;
    text-align: center;
  }
  
  .footer-content {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-bottom: .5rem;
  }
  
  .footer-content h3 {
    margin-bottom: .5rem;
    font-size: 1.5rem;
  }
  
  .social-icons {
    display: flex;
    gap: 1rem;
  }
  
  .social-icons a {
    color: white;
    transition: color 0.3s ease;
  }
  
  .social-icons a:hover {
    color: #709909ba; /* Change to your theme color */
  }
  
  .footer-bottom {
    font-size: 0.9rem;
  }
  </style>