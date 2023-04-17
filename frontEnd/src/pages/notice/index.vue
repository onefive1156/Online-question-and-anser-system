<template>
    <div>通知页面</div>
    <button @click="back">返回</button>
</template>

<script setup>
    import { ref } from 'vue'
const back = ()=>{
    uni.navigateBack({
        delta: 1
    })
}
</script>

<style scoped lang="scss">

</style>