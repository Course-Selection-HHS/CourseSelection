<template>
  <div class="home">
    <div id="main">
      <h1>Find the right class for you</h1>
      <router-link to="/potato" id="quiz">Quiz</router-link>
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

  display: grid;

  #main {
    place-self: center;
  }
}
</style>
