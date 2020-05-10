<template>
  <div id="body">
    <div class="home">
      <div id="main">
        <h1>Find the right class for you</h1>
        <p>HHS Course Selection allows you to find classes that suit you. You can find classes that you would never have thought to take or heard of. This Quiz will limit the time and effort it takes for you to find the right class for you.</p>
        <button>
          <router-link to="/quiz" id="quiz">Quiz</router-link>
        </button>
      </div>
    </div>
    <div class="quotes">
      <div id="main">
        <h1 id="title">Make your course selection process easier</h1>
        <div id="grid">
          <Card v-for="data in [['John Smith', 'sample text.'],
                                /*['Edgy Teenager', 'i am very cool. So cool infact that my blood stream is frozen. All parts of my body that contain water have been ruptured due to the fact that frozen water—ice, as you peons call it—expands. This expansion causes the particles to form a lattice and make the particles almost static, a behavior quite stark in comparison to fluid. '],*/
                                ['Lincoln President', 'sample text.'],
                                ['Tired Student', 'sample text']]" 
                :key="data[0]" :title="data[0]" :body="data[1]"/>
        </div>
      </div>
    </div>
    <!-- <hr>
    <div class="info">
      <div id="main">
        <h1 id="title">How does it work?</h1>

      </div>
    </div> -->
  </div>
</template>

<script>
// @ is an alias to /src
// import HelloWorld from '@/components/HelloWorld.vue'
import Card from '../components/Card.vue'

export default {
  name: 'Home',
  components: {
    Card
  }
}
</script>

<style scoped lang="scss">
#body {
  z-index: 0;
  position: relative;
  display: inline-block;
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
      transition: all .3s;
      box-shadow: 0px 5px 32px -1px rgba(0,0,0,0.16);

      &:hover {
        transform: scale(1.1);
        background: var(--red3);
      }

      &:active {
        background: rgb(128, 128, 128);
      }

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

.quotes {
  width: 100vw;
  min-height: 75vh;

  #main {
    --padding: 50px;
    padding: var(--padding) 0px;
    width: 100%;
    min-height: calc(100vh - calc(var(--padding) * 2));

    display: grid;
    grid-template-rows: auto 1fr;
    row-gap: 20px;

    #title {
      margin: auto;
      padding: 0px 10px;
      place-self: center;
    }

    #grid {
      --gridPadding: 20px;
      width: calc(100vw - calc(2 * var(--gridPadding)));
      height: 100%;
      padding: var(--gridPadding);
      place-self: center;
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(310px, 1fr));
      grid-auto-flow: row;
      column-gap: auto;
      row-gap: 20px;

      div {
        place-self: center;
      }
    }
  }
}

.info {
  // #main::before {
  //   content: "";
  //   display: inline-block;
  //   background: grey;
  //   width: 100vw;
  //   height: 2px;
  // }
}
</style>
