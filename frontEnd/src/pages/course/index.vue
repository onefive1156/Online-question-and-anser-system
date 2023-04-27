<template>
    <view class="content">
        <fui-list>
            <fui-list-cell v-for="item in studyYearList" @click="toCourseList(item)" :key="item" arrow :topBorder="true">
                {{item}}
            </fui-list-cell>
        </fui-list>
    </view>
</template>

<script setup>
    import {ref} from 'vue'
    const studyYearList = ref(['当前学年', '2021至2022','2020至2021','2019至2020'])
    const toCourseList = (index)=>{
        uni.navigateTo({
            url: '/pages/courseList/index?index=' + index
        })}
</script>

<style lang="scss" scoped>
    .content{
        width: 100%;
        height: 100%;
        padding: 12rpx 12rpx 12rpx 12rpx;
    }
</style>