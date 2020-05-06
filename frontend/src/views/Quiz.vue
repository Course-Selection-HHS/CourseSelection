<template>
    <div id="quiz_body">
        <h1 id="quiz_title">Quiz</h1>
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
  questions?: object = {}
 
  async created() {
    this.questions = (await fetch('http://localhost:8000/getSurvey').then(_ => _.json())).questions
  }
}
</script>

<style lang="scss" scoped>
#quiz_body {
    width: 100vw;
    min-height: 100vh;
    display: inline-block;

    box-shadow: inset 0px 5px 43px 2px rgba(0,0,0,0.1);
}
</style>