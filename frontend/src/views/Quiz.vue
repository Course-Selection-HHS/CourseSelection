<template>
    <div id="quiz">
        <div id="quiz_head">
          <h1 id="quiz_title">Quiz</h1>

          <div id="info">
            <Card title="Timing" body="Take as long as you want" size="300" :isQuestion="true" />
            <Card title="Honesty" body="Make sure to answer as honestly as a you can" size="300" :isQuestion="true" />
            <Card title="Precision" body="Answer every question if you want the quiz to work" size="300" :isQuestion="true" />
          </div>
        </div>
        <div id="quiz_body">
          <div class="q" :v-if="got" v-for="(q, i) in questions" :key="i">
            <Question :data="q" :info="[i + 1, questions.length]" @sel="test" />
          </div>
          <button id="submit" :disabled="!finished">
              Submit
          </button>
        </div>
    </div>
</template>

<script lang="ts">
// import Hamburger from "./components/Hamburger.vue"
import { Component, Vue } from 'vue-property-decorator'
import Card from '../components/Card.vue'
import Question from '../components/Question.vue'

@Component({
  name: "Quiz",
  components: {
    Card,
    Question
  }
})
export default class Quiz extends Vue {
  questions?: Array<object> = []
  answers: Array<Answer> = []
  got = false
  finished = false
 
  test(data: [number, Answer]) {
    this.answers[data[0]] = data[1]
    this.finished = this.questions ? this.answers.filter(_ => _).length == this.questions.length: false
  }

  async created() {
    this.questions = (await fetch('http://localhost:8000/getSurvey').then(_ => _.json())).questions as Array<object>
    this.questions = [...this.questions, ...this.questions, ...this.questions]
    this.got = true
  }
}

interface Answer {
  type: string, 
  id: number, 
  answer: Array<number>
}
</script>

<style lang="scss" scoped>
#quiz {
    width: 100vw;
    // min-height: 100vh;
    display: inline-block;
    display: grid;
    grid-template-rows: auto 1fr;
    // padding-bottom: 100px;

    #quiz_head {
      // paddin
      box-shadow: inset 0px 5px 43px 2px rgba(0,0,0,0.1);
      background-color: var(--white2);
      height: auto;
      padding-bottom: 50px;

      #quiz_title {
        margin: 0px;
        padding: 30px;
      }

      #info {
        display: grid;
        grid-template-columns: repeat(auto-fit, minmax(310px, 1fr));
        grid-auto-flow: row;
        column-gap: auto;
        row-gap: 40px;
        place-items: center;
        height: 80%;
      }
    }

    #quiz_body {
      height: 100%;
      display: grid;
      // grid-template-rows: repeat(auto-fill, minmax(min-content, max-content));
      grid-auto-rows: minmax(min-content, max-content);
      padding: 50px 0px;
      row-gap: 50px;

      .q {
        display: inline-block;
      }

      #submit {
          margin: 10px;
          width: 7em;
          place-self: center;
          // height: 2.5em;
          padding: 5px 10px;
          font-size: 1.3rem;
          background: rgb(128, 128, 128);
          color: var(--white1);
          border: 1px solid transparent;
          border-radius: 20px;
          transition: all .3s;
          box-shadow: 0px 5px 32px -1px rgba(0,0,0,0.16);

          &:hover, &:not(disabled) {
            transform: scale(1.1);
            background: var(--red2);
          }

          &:active {
            transform: scale(.9);
            background: var(--red3);
          }

          &:disabled {
            background:rgb(128, 128, 128);;
          }

          &:focus {
            outline: none;
          }
        }
    }
}
</style>