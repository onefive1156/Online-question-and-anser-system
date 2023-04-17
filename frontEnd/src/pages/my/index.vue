<template>
    <div>
        我的
    </div>
    <button @click="back">
        返回
    </button>
    <button @click="toNotice">
        公告
    </button>
</template>

<script setup>
    import { ref } from 'vue'
const back = ()=>{
    uni.switchTab({
        url: '/pages/index/index'
    })
}
const toNotice = ()=>{
        uni.navigateTo({
            url: '/pages/notice/index'
        })
}
</script>

<style scoped lang="scss">
</style>