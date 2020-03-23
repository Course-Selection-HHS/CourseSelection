<template>
  <div id="app">
    <div id="nav">
      <span id="name">Course Selection</span>
      <img id="hhs" src="https://upload.wikimedia.org/wikipedia/en/e/e2/HSInfo1.jpeg" alt="hhs" width="100" hei>
      <div id="links">
        <router-link to="/">Home</router-link>
        <router-link to="/">Courses</router-link> 
        <router-link to="/">Tags</router-link>
        <router-link to="/Quiz.vue" id="quiz">Quiz</router-link>
      </div>
      <!-- <router-link to="/about">About</router-link> -->
      <Hamburger/>
    </div>
    <router-view/>
  </div>
</template>

<script lang="ts">
import Hamburger from "./components/sub/Hamburger.vue"

export default {
  name: 'Home',
  components: {
    Hamburger
  }
}
</script>

<style lang="scss">
@import url('https://fonts.googleapis.com/css?family=Open+Sans:400,600&display=swap');
/*#region*/
:root {
  --red1: #EF233C;
  --red2: #D90429;
  --white: #EDF2F4;
  --lightgrey1: #8D99AE;
  --lightgrey2: #818C9F;
  --grey1: #646675;
  --grey2: #2B2D42;

  --red3: #b30000;
}

::selection {
  background-color: var(--red3);
  color: white;
}

::-webkit-scrollbar {
  width: 5px;
  background: var(--white);
}

::-webkit-scrollbar-thumb {
  background: var(--red3); 
  border-radius: 10px;
  
  transition: transform .3s;
}
/*#endregion*/
* {
  font-family: 'Open Sans', sans-serif;
  -webkit-font-smoothing: subpixel-antialiased;
}

body {
  margin: 0px;
  overflow-x: hidden;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: var(--grey1);
}

#nav {
  padding: 15px;
  display: grid;
  height: calc(100px - 2 * 15px);
  z-index: 2;

  grid-template-rows: 1fr;
  grid-template-columns: 200px 190px 1fr auto;

  #name {
    grid-column: 1;
    font-size: 1.3em;
  }

  #links {
    grid-column: 4;
    display: grid;
    grid-auto-flow: column;
    gap: 50px;

    #quiz {
      --size: 10px;

      padding: calc(var(--size) / 2) var(--size);
      border-radius: 5px;
      margin-left: calc(-1 * var(--size));
      border: 1px solid var(--red3);
    }
  }

  a {
    font-weight: 600;
    text-decoration: none;
    color: var(--grey1);

    transition: transform .3s;
    backface-visibility: hidden;

    &.router-link-exact-active {
      color: var(--red2);
    }

    &:hover {
      transform: scale(1.25);
      color: var(--red3);
    }
  }

  #name, a {
    place-self: center;
  }

  @media (min-width: 650px) {
    #hamburger {
      display:none;
    }
  }

  @media (max-width: 765px) {
    #hhs {
      display: none;
    }
    & {
      grid-template-columns: 200px 1fr auto;
    }
  }

  @media (max-width: 650px) {
    #hamburger {
      grid-column: 3;
      align-self: center;
      justify-self: center;
    }

    #links {
      display:none;
    }
  }
}
</style>
