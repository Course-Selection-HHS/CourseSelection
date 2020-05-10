<template>
  <div class="question">
    <span id="tiny">(#{{info[0]}} of {{info[1]}})</span>
    <span id="title">{{data.text}}</span>
    <!-- <span></span> -->
    <div :id="info[0]">
      <button v-for="d in data.options" @click="c(d, info[0], data.options.indexOf(d))" v-bind="{'c': sel[data.options.indexOf(d)]}" :key="d">{{d}}</button>
    </div>
  </div>
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator';

@Component
export default class Question extends Vue {
  @Prop() private data!: Q
  @Prop() private info!: Array<number>
  sel: Array<boolean> = (new Array(this.data.options.length)).fill(false)

  get single() {
    return this.data.type == "tf" || this.data.type == "multi"
  }  

  c(s: string, i: number, e: number) {
    this.sel = this.sel.map((_, b) => this.single ? b == e : (b == e ? !_ : _))
    if(this.sel.filter(_ => _).length == 0)
      this.sel[e] = true
    this.$emit("sel", [this.info[0]-1, {type: this.data.type, id: this.data.id, answer: this.sel.map(_ => _ ? 1 : 0)}])
  }
}

// eslint-disable-next-line
interface Q {
  type: string,
  text: string,
  options: Array<string>,
  id: string
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
.question {
  margin: auto;
  min-height: 150px;
  border-radius: 20px;
  width: 80vw;
  max-width: 500px;
  background: linear-gradient(4deg, rgba(247,247,247,1) 0%, rgba(255,255,255,1) 100%);
  opacity: .9;
  box-shadow: 0px 10px 32px -1px rgba(0,0,0,0.16);
  padding: 20px 30px;
  display: grid;
  font-size: 1.2rem;

  button {
    margin: 10px;
    // width: 7em;
    // height: 2.5em;
    padding: 5px 10px;
    font-size: 1.1rem;
    background:rgb(128, 128, 128);
    color: var(--white1);
    border: 1px solid transparent;
    border-radius: 20px;
    transition: all .3s;
    box-shadow: 0px 5px 32px -1px rgba(0,0,0,0.16);

    &:hover {
      transform: scale(1.1);
      background: var(--red3);
    }

    &:active {
      transform: scale(.9);
    }

    &[c=true] {
      background: var(--red2);
    }

    &:focus {
      outline: none;
    }
  }

  #tiny {
    position: relative;
    text-align: left;
    font-size: .9rem;
  }

  #title {
    position: relative
  }
}
</style>
