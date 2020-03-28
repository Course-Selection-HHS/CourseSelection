<template>
  <div id="body">
    <div class="home">
      <div id="main">
        <h1>Find the right class for you</h1>
        <p>HHS Course Selection allows you to find classes that suit you. You can find classes that you would never have thought to take or heard of. This Quiz will limit the time and effort it takes for you to find the right class for you.</p>
        <button>
          <router-link to="quiz" id="quiz">Quiz</router-link>
        </button>
      </div>
    </div>
    <div class="quotes">
      <p>hello there</p>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
// import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'Home',
  components: {
    // HelloWorld
  }
}
</script>

<style scoped lang="scss">
#body {
  z-index: -1;
  position: relative;
}

.home {
  background-color: var(--white2);
  height: 89.8vh;
  z-index: -1;
  box-shadow: inset 0px 5px 43px 2px rgba(0,0,0,0.1);

  display: grid;

  #main {
    place-self: center;
    padding: 10px;
    text-align: center;
    margin: 10px;

    p {
      width: 30em;
      margin: 5px auto 20px;
      font-size: 1.1em;
    }

    button {
      width: 7em;
      height: 2.5em;
      background: var(--red2);
      color: var(--white1);
      font-size: 1.3em;
      border: 1px solid transparent;
      border-radius: 20px;

      a {
        text-decoration: none;
        color: white;
        width: 100%;
        height: 100%;
      }
    }

    @media (min-width: 1400px) {
      p {
        font-size: 1.3em;
      }
      button {
        font-size: 1.5em;
      }
      h1 {
        font-size: 2.2em;
      }
    }

    @media (max-width: 650px) {
      p {
        font-size: .9em;
      }
      button {
        font-size: 1.2em;
      }
      h1 {
        font-size: 1.8em;
      }
    }

    @media (max-width: 465px) {
      #main {
        width: 100vw;
      }
      p, h1 {
        width: 100%;
      }
    }
  }
}
</style>
