<template>
  <div id="app">
    <div id="nav">
      <span id="name">Course Selection</span>
      <img id="hhs" src="https://upload.wikimedia.org/wikipedia/en/e/e2/HSInfo1.jpeg" alt="hhs" height="70">
      <transition name="sidenav">
        <div id="links" :class="cName" v-if="(cName == 'mobile') || !changed">
          <router-link to="/" @click="sidebar"><span @click="sidebaR">Home</span></router-link>
          <router-link to="/courses" @click="sidebar"><span @click="sidebaR">Courses</span></router-link> 
          <router-link to="/potato" @click="sidebar"><span @click="sidebaR">Tags</span></router-link>
          <router-link to="/quiz" id="quiz"><span @click="sidebaR">Quiz</span></router-link>
        </div>
      </transition>
      <div id="hamburger_parent" @click="sidebar"><Hamburger/></div>
    </div>
    <transition name="fade" mode="out-in">
      <router-view/>
    </transition>
    <transition name="blanket">
      <!-- <div id="shadow_blanket_parent"> -->
        <div id="shadow_blanket" v-if="cName == 'mobile'" @click="sidebar"></div>
      <!-- </div> -->
    </transition>
    <div id="footer">
      <div id="footer-inner">
        <router-link to="/"><span>Home</span></router-link>
        <router-link to="/courses"><span>Courses</span></router-link> 
        <router-link to="/potato"><span >Tags</span></router-link>
        <router-link to="/quiz" id="quiz"><span >Quiz</span></router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import Hamburger from "./components/Hamburger.vue"
import { Component, Vue } from 'vue-property-decorator';

@Component({
  name: "Home",
  components: {
    Hamburger
  }
})
export default class Home extends Vue {
  cName = "regular"
  changed = false
  hiddenClass = ""

  sidebar(): void {
    // eslint-disable-next-line
    this.cName = this.cName == "mobile" ? "regular" : "mobile"
    this.hiddenClass = this.cName == "mobile" ? "hide" : ""
    this.changed = true
  }

  sidebaR(): void {
    this.cName = "regular"
  }
}
</script>

<style lang="scss">

@import url('https://fonts.googleapis.com/css?family=Open+Sans:400,600&display=swap');
@use './sass/background';

/*#region PsudoElements*/
  :root {
    --red1: #EF233C;
    --red2: #D90429;
    --white1: rgb(247, 245, 245);
    --white2:rgb(244, 244, 244);
    --lightgrey1: rgb(174, 174, 174);
    --lightgrey2: rgb(159, 159, 159);
    --grey1: rgb(100, 100, 100);
    --grey2: rgb(43, 43, 43);
    --grey3: rgb(23, 23, 23);

    --red3: #b30000;

    /* 
    Old colors:
      --white: #EDF2F4;
      --lightgrey1: #8D99AE;
      --lightgrey2: #818C9F;
      --grey1: #646675;
      --grey2: rgb(43, 45, 66);
    */
  }

  ::selection {
    background-color: var(--red3);
    color: white;
  }

  ::-webkit-scrollbar {
    width: 5px;
    background: var(--white1);
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
  backface-visibility: hidden;
  transform: translateZ(0);
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
  color: var(--grey2);
}

#nav {
  padding: 15px;
  display: grid;
  height: calc(100px - 2 * 15px);

  grid-template-rows: 1fr;
  grid-template-columns: 200px 190px 1fr auto;

  .hide {
    display: none;
    opacity: 0;
  }

  #name {
    grid-column: 1;
    font-size: 1.3em;
  }

  #links.regular {
    grid-column: 4;
    display: grid;
    grid-auto-flow: column;
    gap: 50px;
  }

  #links.mobile {
    position: fixed;
    right: 0px;
    top: 0px;
    width: 50vw;
    height: 100vh;
    z-index: 999 !important;
    background: var(--grey3);

    display: grid;
    // grid-template-rows: ;

    a.router-link-exact-active {
      color: white;
    }
  }

  a {
    font-weight: 400;
    text-decoration: none;
    color: var(--red2);

    transition: all .3s;
    backface-visibility: hidden;

    &#quiz {
      --size: 15px;
      --color: var(--red2);

      padding: calc(var(--size) / 2) var(--size);
      border-radius: 20px;
      margin-left: calc(-1 * var(--size));
      border: 1px solid var(--color);
      background-color: var(--color);
      color: var(--white1);
    }

    &.router-link-exact-active {
      color: var(--grey2);

      &#quiz {
        --color: var(--lightgrey1);

        border-color: var(--color) !important;
        background-color: var(--color) !important;
      }
    }

    &:hover {
      transform: scale(1.25);
      color: var(--red3);

      &#quiz {
        border-color: var(--red3) !important;
        background: var(--red3) !important;
      }
    }
  }

  #name, a {
    place-self: center;
  }

  @media (min-width: 651px) {
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

    #links.regular {
      display:none;
    }

    #hhs {
      display: block;
    }
  }

  @media (max-width: 550px) {
    #hhs {
      display: none;
    }
  }
}

#hamburger_parent {
  display: contents;
}

#footer {
  background: var(--grey3);
  width: 100vw;
  height: 100px;
  display:grid;
  grid-template-columns: 1fr auto 1fr;

  #footer-inner {
    width: 50vw;
    grid-column: 2;

    place-self: center;
    display: grid;
    grid-auto-flow: column;
    column-gap: 10px;
    grid-auto-columns: auto;

    a {
      font-size: 1.05em;
      color: white;
      text-decoration: none;
      transition: transform .3s;

      &:hover {
        transform: scale(1.3);
      }
    }

    @media (max-width: 450px) {
      & {
        width: 100vw;
      }
    }
  }
}
// #region shadowblanked
  #shadow_blanket_parent {
    display: contents;
    position: fixed;
  }

  #shadow_blanket {
    position: fixed;
    top: 0px;
    left: 0px;
    width: 100vw;
    height: 100vh;
    opacity: .6;
    background: #000;
    z-index: -1;
  }
// #endregion
// #region transitions
  .sidenav-enter-active, .sidenav-leave-active {
    // transition: opacity .5s;
    transition: transform .5s;
  }
  .sidenav-enter, .sidenav-leave-to /* .fade-leave-active below version 2.1.8 */ {
    // opacity: 0;
    transform: translate(50vw, 0px);
  }

  .blanket-enter-active, .blanket-leave-active {
    // transition: opacity .3s;
    transition: transform .5s;
  }

  .blanket-enter, .blanket-leave-to /* .fade-leave-active below version 2.1.8 */ {
    // opacity: 0;
    // opacity: .5;
    transform: translate(100vw, 0px);
  }

  .fade-enter-active,
  .fade-leave-active {
    transition-duration: 0.3s;
    transition-property: opacity;
    transition-timing-function: ease;
  }

  .fade-enter,
  .fade-leave-active {
    opacity: 0
  }
// #endregion
</style>
