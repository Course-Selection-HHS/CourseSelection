(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["about"],{"10a4":function(t,e,r){},1884:function(t,e,r){"use strict";r.r(e);var n=function(){var t=this,e=t.$createElement;t._self._c;return t._m(0)},i=[function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",{attrs:{id:"tags_body"}},[r("h1",{attrs:{id:"title"}},[t._v("under construction")])])}],o=(r("b20f"),r("2877")),a={},c=Object(o["a"])(a,n,i,!1,null,"47ef191e",null);e["default"]=c.exports},"1a2f":function(t,e,r){"use strict";r.r(e);var n=function(){var t=this,e=t.$createElement;t._self._c;return t._m(0)},i=[function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",{attrs:{id:"courses_body"}},[r("h1",[t._v("under construction")])])}],o=(r("50fe"),r("2877")),a={},c=Object(o["a"])(a,n,i,!1,null,"d67d5e62",null);e["default"]=c.exports},"1dde":function(t,e,r){var n=r("d039"),i=r("b622"),o=r("2d00"),a=i("species");t.exports=function(t){return o>=51||!n((function(){var e=[],r=e.constructor={};return r[a]=function(){return{foo:1}},1!==e[t](Boolean).foo}))}},"202d":function(t,e,r){"use strict";var n=r("dcde"),i=r.n(n);i.a},"2e44":function(t,e,r){"use strict";r.r(e);var n=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",{attrs:{id:"quiz"}},[r("div",{attrs:{id:"quiz_head"}},[r("h1",{attrs:{id:"quiz_title"}},[t._v("Quiz")]),r("div",{attrs:{id:"info"}},[r("Card",{attrs:{title:"Timing",body:"Take as long as you want",size:"300",isQuestion:!0}}),r("Card",{attrs:{title:"Honesty",body:"Make sure to answer as honestly as a you can",size:"300",isQuestion:!0}}),r("Card",{attrs:{title:"Precision",body:"Answer every question if you want the quiz to work",size:"300",isQuestion:!0}})],1)]),r("div",{attrs:{id:"quiz_body"}},[t._l(t.questions,(function(e,n){return r("div",{key:n,staticClass:"q",attrs:{"v-if":t.got}},[r("Question",{attrs:{data:e,info:[n+1,t.questions.length]},on:{sel:t.test}})],1)})),r("button",{attrs:{id:"submit",disabled:!t.finished},on:{click:t.submit}},[t._v(" Submit ")])],2)])},i=[];r("4de4"),r("a15b"),r("d3b7");function o(t,e){(null==e||e>t.length)&&(e=t.length);for(var r=0,n=new Array(e);r<e;r++)n[r]=t[r];return n}function a(t){if(Array.isArray(t))return o(t)}r("a4d3"),r("e01a"),r("d28b"),r("a630"),r("e260"),r("3ca3"),r("ddb0");function c(t){if("undefined"!==typeof Symbol&&Symbol.iterator in Object(t))return Array.from(t)}r("fb6a"),r("b0c0"),r("25f0");function u(t,e){if(t){if("string"===typeof t)return o(t,e);var r=Object.prototype.toString.call(t).slice(8,-1);return"Object"===r&&t.constructor&&(r=t.constructor.name),"Map"===r||"Set"===r?Array.from(r):"Arguments"===r||/^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(r)?o(t,e):void 0}}function s(){throw new TypeError("Invalid attempt to spread non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}function f(t){return a(t)||c(t)||u(t)||s()}r("96cf"),r("e6cf");function l(t,e,r,n,i,o,a){try{var c=t[o](a),u=c.value}catch(s){return void r(s)}c.done?e(u):Promise.resolve(u).then(n,i)}function h(t){return function(){var e=this,r=arguments;return new Promise((function(n,i){var o=t.apply(e,r);function a(t){l(o,n,i,a,c,"next",t)}function c(t){l(o,n,i,a,c,"throw",t)}a(void 0)}))}}var d=r("d4ec"),v=r("bee2"),p=r("2caf"),y=r("262e"),g=r("9ab4"),b=r("60a3"),m=r("ae8d"),w=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",{staticClass:"question"},[r("span",{attrs:{id:"tiny"}},[t._v("(#"+t._s(t.info[0])+" of "+t._s(t.info[1])+")")]),r("span",{attrs:{id:"title"}},[t._v(t._s(t.data.text))]),r("div",{attrs:{id:t.info[0]}},t._l(t.data.options,(function(e){return r("button",t._b({key:e,on:{click:function(r){t.c(e,t.info[0],t.data.options.indexOf(e))}}},"button",{c:t.sel[t.data.options.indexOf(e)]},!1),[t._v(t._s(e))])})),0)])},_=[],x=(r("cb29"),r("d81d"),function(t){Object(y["a"])(r,t);var e=Object(p["a"])(r);function r(){var t;return Object(d["a"])(this,r),t=e.apply(this,arguments),t.sel=new Array(t.data.options.length).fill(!1),t}return Object(v["a"])(r,[{key:"c",value:function(t,e,r){var n=this;this.sel=this.sel.map((function(t,e){return n.single?e==r:e==r?!t:t})),0==this.sel.filter((function(t){return t})).length&&(this.sel[r]=!0),this.$emit("sel",[this.info[0]-1,{type:this.data.type,id:this.data.id,answer:this.sel.map((function(t){return t?1:0}))}])}},{key:"single",get:function(){return"tf"==this.data.type||"multi"==this.data.type}}]),r}(b["c"]));Object(g["a"])([Object(b["b"])()],x.prototype,"data",void 0),Object(g["a"])([Object(b["b"])()],x.prototype,"info",void 0),x=Object(g["a"])([b["a"]],x);var O=x,j=O,E=(r("e3ac"),r("2877")),L=Object(E["a"])(j,w,_,!1,null,"1e137d6a",null),A=L.exports,k=function(t){Object(y["a"])(r,t);var e=Object(p["a"])(r);function r(){var t;return Object(d["a"])(this,r),t=e.apply(this,arguments),t.questions=[],t.answers=[],t.got=!1,t.finished=!1,t}return Object(v["a"])(r,[{key:"test",value:function(t){this.answers[t[0]]=t[1],this.finished=!!this.questions&&this.answers.filter((function(t){return t})).length==this.questions.length}},{key:"created",value:function(){var t=h(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,fetch("https://phase1-cs.herokuapp.com/getSurvey").then((function(t){return t.json()}));case 2:this.questions=t.sent.questions,this.questions=f(this.questions),this.got=!0;case 5:case"end":return t.stop()}}),t,this)})));function e(){return t.apply(this,arguments)}return e}()},{key:"submit",value:function(){fetch("https://phase1-cs.herokuapp.com/getCourses",{method:"POST",body:JSON.stringify({answers:this.answers})}).then((function(t){return t.json()})).then((function(t){return alert(t["courses"].join("\n"))}))}}]),r}(b["c"]);k=Object(g["a"])([Object(b["a"])({name:"Quiz",components:{Card:m["a"],Question:A}})],k);var S=k,q=S,C=(r("202d"),Object(E["a"])(q,n,i,!1,null,"1777a63d",null));e["default"]=C.exports},"4de4":function(t,e,r){"use strict";var n=r("23e7"),i=r("b727").filter,o=r("1dde"),a=r("ae40"),c=o("filter"),u=a("filter");n({target:"Array",proto:!0,forced:!c||!u},{filter:function(t){return i(this,t,arguments.length>1?arguments[1]:void 0)}})},"4df4":function(t,e,r){"use strict";var n=r("0366"),i=r("7b0b"),o=r("9bdd"),a=r("e95a"),c=r("50c4"),u=r("8418"),s=r("35a1");t.exports=function(t){var e,r,f,l,h,d,v=i(t),p="function"==typeof this?this:Array,y=arguments.length,g=y>1?arguments[1]:void 0,b=void 0!==g,m=s(v),w=0;if(b&&(g=n(g,y>2?arguments[2]:void 0,2)),void 0==m||p==Array&&a(m))for(e=c(v.length),r=new p(e);e>w;w++)d=b?g(v[w],w):v[w],u(r,w,d);else for(l=m.call(v),h=l.next,r=new p;!(f=h.call(l)).done;w++)d=b?o(l,g,[f.value,w],!0):f.value,u(r,w,d);return r.length=w,r}},"50fe":function(t,e,r){"use strict";var n=r("10a4"),i=r.n(n);i.a},"7e70":function(t,e,r){},"7f81":function(t,e,r){},"81d5":function(t,e,r){"use strict";var n=r("7b0b"),i=r("23cb"),o=r("50c4");t.exports=function(t){var e=n(this),r=o(e.length),a=arguments.length,c=i(a>1?arguments[1]:void 0,r),u=a>2?arguments[2]:void 0,s=void 0===u?r:i(u,r);while(s>c)e[c++]=t;return e}},8418:function(t,e,r){"use strict";var n=r("c04e"),i=r("9bf2"),o=r("5c6c");t.exports=function(t,e,r){var a=n(e);a in t?i.f(t,a,o(0,r)):t[a]=r}},"96cf":function(t,e,r){var n=function(t){"use strict";var e,r=Object.prototype,n=r.hasOwnProperty,i="function"===typeof Symbol?Symbol:{},o=i.iterator||"@@iterator",a=i.asyncIterator||"@@asyncIterator",c=i.toStringTag||"@@toStringTag";function u(t,e,r,n){var i=e&&e.prototype instanceof p?e:p,o=Object.create(i.prototype),a=new k(n||[]);return o._invoke=j(t,r,a),o}function s(t,e,r){try{return{type:"normal",arg:t.call(e,r)}}catch(n){return{type:"throw",arg:n}}}t.wrap=u;var f="suspendedStart",l="suspendedYield",h="executing",d="completed",v={};function p(){}function y(){}function g(){}var b={};b[o]=function(){return this};var m=Object.getPrototypeOf,w=m&&m(m(S([])));w&&w!==r&&n.call(w,o)&&(b=w);var _=g.prototype=p.prototype=Object.create(b);function x(t){["next","throw","return"].forEach((function(e){t[e]=function(t){return this._invoke(e,t)}}))}function O(t,e){function r(i,o,a,c){var u=s(t[i],t,o);if("throw"!==u.type){var f=u.arg,l=f.value;return l&&"object"===typeof l&&n.call(l,"__await")?e.resolve(l.__await).then((function(t){r("next",t,a,c)}),(function(t){r("throw",t,a,c)})):e.resolve(l).then((function(t){f.value=t,a(f)}),(function(t){return r("throw",t,a,c)}))}c(u.arg)}var i;function o(t,n){function o(){return new e((function(e,i){r(t,n,e,i)}))}return i=i?i.then(o,o):o()}this._invoke=o}function j(t,e,r){var n=f;return function(i,o){if(n===h)throw new Error("Generator is already running");if(n===d){if("throw"===i)throw o;return q()}r.method=i,r.arg=o;while(1){var a=r.delegate;if(a){var c=E(a,r);if(c){if(c===v)continue;return c}}if("next"===r.method)r.sent=r._sent=r.arg;else if("throw"===r.method){if(n===f)throw n=d,r.arg;r.dispatchException(r.arg)}else"return"===r.method&&r.abrupt("return",r.arg);n=h;var u=s(t,e,r);if("normal"===u.type){if(n=r.done?d:l,u.arg===v)continue;return{value:u.arg,done:r.done}}"throw"===u.type&&(n=d,r.method="throw",r.arg=u.arg)}}}function E(t,r){var n=t.iterator[r.method];if(n===e){if(r.delegate=null,"throw"===r.method){if(t.iterator["return"]&&(r.method="return",r.arg=e,E(t,r),"throw"===r.method))return v;r.method="throw",r.arg=new TypeError("The iterator does not provide a 'throw' method")}return v}var i=s(n,t.iterator,r.arg);if("throw"===i.type)return r.method="throw",r.arg=i.arg,r.delegate=null,v;var o=i.arg;return o?o.done?(r[t.resultName]=o.value,r.next=t.nextLoc,"return"!==r.method&&(r.method="next",r.arg=e),r.delegate=null,v):o:(r.method="throw",r.arg=new TypeError("iterator result is not an object"),r.delegate=null,v)}function L(t){var e={tryLoc:t[0]};1 in t&&(e.catchLoc=t[1]),2 in t&&(e.finallyLoc=t[2],e.afterLoc=t[3]),this.tryEntries.push(e)}function A(t){var e=t.completion||{};e.type="normal",delete e.arg,t.completion=e}function k(t){this.tryEntries=[{tryLoc:"root"}],t.forEach(L,this),this.reset(!0)}function S(t){if(t){var r=t[o];if(r)return r.call(t);if("function"===typeof t.next)return t;if(!isNaN(t.length)){var i=-1,a=function r(){while(++i<t.length)if(n.call(t,i))return r.value=t[i],r.done=!1,r;return r.value=e,r.done=!0,r};return a.next=a}}return{next:q}}function q(){return{value:e,done:!0}}return y.prototype=_.constructor=g,g.constructor=y,g[c]=y.displayName="GeneratorFunction",t.isGeneratorFunction=function(t){var e="function"===typeof t&&t.constructor;return!!e&&(e===y||"GeneratorFunction"===(e.displayName||e.name))},t.mark=function(t){return Object.setPrototypeOf?Object.setPrototypeOf(t,g):(t.__proto__=g,c in t||(t[c]="GeneratorFunction")),t.prototype=Object.create(_),t},t.awrap=function(t){return{__await:t}},x(O.prototype),O.prototype[a]=function(){return this},t.AsyncIterator=O,t.async=function(e,r,n,i,o){void 0===o&&(o=Promise);var a=new O(u(e,r,n,i),o);return t.isGeneratorFunction(r)?a:a.next().then((function(t){return t.done?t.value:a.next()}))},x(_),_[c]="Generator",_[o]=function(){return this},_.toString=function(){return"[object Generator]"},t.keys=function(t){var e=[];for(var r in t)e.push(r);return e.reverse(),function r(){while(e.length){var n=e.pop();if(n in t)return r.value=n,r.done=!1,r}return r.done=!0,r}},t.values=S,k.prototype={constructor:k,reset:function(t){if(this.prev=0,this.next=0,this.sent=this._sent=e,this.done=!1,this.delegate=null,this.method="next",this.arg=e,this.tryEntries.forEach(A),!t)for(var r in this)"t"===r.charAt(0)&&n.call(this,r)&&!isNaN(+r.slice(1))&&(this[r]=e)},stop:function(){this.done=!0;var t=this.tryEntries[0],e=t.completion;if("throw"===e.type)throw e.arg;return this.rval},dispatchException:function(t){if(this.done)throw t;var r=this;function i(n,i){return c.type="throw",c.arg=t,r.next=n,i&&(r.method="next",r.arg=e),!!i}for(var o=this.tryEntries.length-1;o>=0;--o){var a=this.tryEntries[o],c=a.completion;if("root"===a.tryLoc)return i("end");if(a.tryLoc<=this.prev){var u=n.call(a,"catchLoc"),s=n.call(a,"finallyLoc");if(u&&s){if(this.prev<a.catchLoc)return i(a.catchLoc,!0);if(this.prev<a.finallyLoc)return i(a.finallyLoc)}else if(u){if(this.prev<a.catchLoc)return i(a.catchLoc,!0)}else{if(!s)throw new Error("try statement without catch or finally");if(this.prev<a.finallyLoc)return i(a.finallyLoc)}}}},abrupt:function(t,e){for(var r=this.tryEntries.length-1;r>=0;--r){var i=this.tryEntries[r];if(i.tryLoc<=this.prev&&n.call(i,"finallyLoc")&&this.prev<i.finallyLoc){var o=i;break}}o&&("break"===t||"continue"===t)&&o.tryLoc<=e&&e<=o.finallyLoc&&(o=null);var a=o?o.completion:{};return a.type=t,a.arg=e,o?(this.method="next",this.next=o.finallyLoc,v):this.complete(a)},complete:function(t,e){if("throw"===t.type)throw t.arg;return"break"===t.type||"continue"===t.type?this.next=t.arg:"return"===t.type?(this.rval=this.arg=t.arg,this.method="return",this.next="end"):"normal"===t.type&&e&&(this.next=e),v},finish:function(t){for(var e=this.tryEntries.length-1;e>=0;--e){var r=this.tryEntries[e];if(r.finallyLoc===t)return this.complete(r.completion,r.afterLoc),A(r),v}},catch:function(t){for(var e=this.tryEntries.length-1;e>=0;--e){var r=this.tryEntries[e];if(r.tryLoc===t){var n=r.completion;if("throw"===n.type){var i=n.arg;A(r)}return i}}throw new Error("illegal catch attempt")},delegateYield:function(t,r,n){return this.delegate={iterator:S(t),resultName:r,nextLoc:n},"next"===this.method&&(this.arg=e),v}},t}(t.exports);try{regeneratorRuntime=n}catch(i){Function("r","regeneratorRuntime = r")(n)}},a15b:function(t,e,r){"use strict";var n=r("23e7"),i=r("44ad"),o=r("fc6a"),a=r("a640"),c=[].join,u=i!=Object,s=a("join",",");n({target:"Array",proto:!0,forced:u||!s},{join:function(t){return c.call(o(this),void 0===t?",":t)}})},a630:function(t,e,r){var n=r("23e7"),i=r("4df4"),o=r("1c7e"),a=!o((function(t){Array.from(t)}));n({target:"Array",stat:!0,forced:a},{from:i})},a640:function(t,e,r){"use strict";var n=r("d039");t.exports=function(t,e){var r=[][t];return!!r&&n((function(){r.call(null,e||function(){throw 1},1)}))}},ae40:function(t,e,r){var n=r("83ab"),i=r("d039"),o=r("5135"),a=Object.defineProperty,c={},u=function(t){throw t};t.exports=function(t,e){if(o(c,t))return c[t];e||(e={});var r=[][t],s=!!o(e,"ACCESSORS")&&e.ACCESSORS,f=o(e,0)?e[0]:u,l=o(e,1)?e[1]:void 0;return c[t]=!!r&&!i((function(){if(s&&!n)return!0;var t={length:-1};s?a(t,1,{enumerable:!0,get:u}):t[1]=1,r.call(t,f,l)}))}},b0c0:function(t,e,r){var n=r("83ab"),i=r("9bf2").f,o=Function.prototype,a=o.toString,c=/^\s*function ([^ (]*)/,u="name";n&&!(u in o)&&i(o,u,{configurable:!0,get:function(){try{return a.call(this).match(c)[1]}catch(t){return""}}})},b20f:function(t,e,r){"use strict";var n=r("7f81"),i=r.n(n);i.a},cb29:function(t,e,r){var n=r("23e7"),i=r("81d5"),o=r("44d2");n({target:"Array",proto:!0},{fill:i}),o("fill")},d81d:function(t,e,r){"use strict";var n=r("23e7"),i=r("b727").map,o=r("1dde"),a=r("ae40"),c=o("map"),u=a("map");n({target:"Array",proto:!0,forced:!c||!u},{map:function(t){return i(this,t,arguments.length>1?arguments[1]:void 0)}})},dcde:function(t,e,r){},e3ac:function(t,e,r){"use strict";var n=r("7e70"),i=r.n(n);i.a},fb6a:function(t,e,r){"use strict";var n=r("23e7"),i=r("861d"),o=r("e8b5"),a=r("23cb"),c=r("50c4"),u=r("fc6a"),s=r("8418"),f=r("b622"),l=r("1dde"),h=r("ae40"),d=l("slice"),v=h("slice",{ACCESSORS:!0,0:0,1:2}),p=f("species"),y=[].slice,g=Math.max;n({target:"Array",proto:!0,forced:!d||!v},{slice:function(t,e){var r,n,f,l=u(this),h=c(l.length),d=a(t,h),v=a(void 0===e?h:e,h);if(o(l)&&(r=l.constructor,"function"!=typeof r||r!==Array&&!o(r.prototype)?i(r)&&(r=r[p],null===r&&(r=void 0)):r=void 0,r===Array||void 0===r))return y.call(l,d,v);for(n=new(void 0===r?Array:r)(g(v-d,0)),f=0;d<v;d++,f++)d in l&&s(n,f,l[d]);return n.length=f,n}})}}]);
//# sourceMappingURL=about.787dc08d.js.map