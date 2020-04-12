<template>
    <div id="quiz_body">
        <h1 id="title">hi my name is quiz, nice to meet you</h1>
    </div>
</template>

<script lang="ts">
// import Hamburger from "./components/Hamburger.vue"
import { Component, Vue } from 'vue-property-decorator';

@Component({
  name: "Quiz",
  components: {
    // Hamburger
  }
})
export default class Quiz extends Vue {
  
}
</script>

<style lang="scss" scoped>
#quiz_body {
    width: 100vw;
    min-height: 100vh;

    box-shadow: inset 0px 5px 43px 2px rgba(0,0,0,0.1);
}
</style>