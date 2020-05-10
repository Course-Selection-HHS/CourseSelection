<template>
  <div class="card" :style="(size ? `height: ${size}px;` : '') ">
      <div id="card-title">{{title}}</div>
      <div id="card-body" :style="(isQuestion ? 'place-self: center; font-size: 1.3rem; margin: -5px; padding: 0px; position: relative; bottom: 15px;' : '')">{{body}}</div>
  </div>
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator';

@Component
export default class Card extends Vue {
    @Prop() private title!: string
    @Prop() private body!: string
    @Prop() private size!: number
    @Prop() private isQuestion!: boolean
}
</script>

<style scoped lang="scss">
    .card {
        height: 425px;
        width: 300px;
        // margin: 10px;

        // border: 3px solid var(--red1);
        background: linear-gradient(4deg, rgba(247,247,247,1) 0%, rgba(255,255,255,1) 100%);
        opacity: .9;
        box-shadow: 0px 10px 32px -1px rgba(0,0,0,0.16);
        color: black;
        border-radius: 20px;

        display: grid;
        grid-template-rows: auto 1fr;
        
        #card-title {
            font-size: 1.5em;
            margin: 20px 0px;

            &:after { 
                content:""; 
                float:left;
                position: relative;
                top: 10px; 
                background:var(--red1); 
                width:100%; 
                height:2.5px; 
                border-radius: 999px;
            }
        }

        #card-body {
            font-size: 1.05em;
            justify-self: stretch;
            padding: 10px 15px;
        }
    }

    @media (max-width: 375px) {
        .card {
            height: 400px;
            width: 275px;

            #card-title {
                font-size: 1.3em;
            }

            #card-body {
                font-size: .95em
            }
        }
    }
</style>
