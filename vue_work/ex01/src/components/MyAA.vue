<template>
  <div>
    <h1>MyAA = {{name}}</h1>
  </div>
</template>
<script>
export default {
  props: {
    aa:{
      type:String,
      default:''
    },
    myname:{
      type: String,
      default:''
    }
  },
  setup (props) {
    // const name = '고길동';
    // return {name}
    // console.log(props);
    return{}
  }
}
</script>

<style lang="scss" scoped>

</style>