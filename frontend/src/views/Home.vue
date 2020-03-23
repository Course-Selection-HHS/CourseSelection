<template>
  <div class="home">
    <div id="main">
      <h1>Find the right class for you</h1>
      <router-link to="/Quiz.vue" id="quiz">Quiz</router-link>
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
.home {
  background-color: var(--white);
  width: 99.9vw;
  height: 90vh;

  box-shadow: inset 0px 5px 43px 2px rgba(0,0,0,0.1);

  display: grid;

  #main {
    place-self: center;
  }
}
</style>
