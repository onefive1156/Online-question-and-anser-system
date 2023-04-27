<template>
    <view class="content">
        <view class="fui-section__title">课程列表</view>
        <fui-card  v-for="item in courseList"  imageRadius="50%"
                   @click=toCourseDetails background="rgba(0,0,0,0.03)"
                   :margin="['24rpx', '32rpx']" :title="item.name" tag="23小时前"
                   :headerLine="false" showBorder>
            <view class="fui-list__item">
                <image class="fui-cover" :src="item.url" mode="widthFix">
                </image>
                <view class="fui-list__title">课程介绍</view>
            </view>
        </fui-card>
    </view>
</template>

<script setup>
    import {onLoad} from '@dcloudio/uni-app'
    import {ref} from 'vue'
    const studyYear = ref('')
    const courseList = ref([{name: '数据结构', url: 'http://localhost:8080/course/1.jpg'}, {name: '数据结构', url: 'http://localhost:8080/course/1.jpg'}])
    onLoad((opts)=>{
        console.log(opts)
        studyYear.value = opts.index
        console.log(studyYear.value)
    })
    const toCourseDetails = ()=>{
        uni.navigateTo({
            url: '/pages/courseDetails/index'
        })
    }
</script>

<style scoped>
    page {
        font-weight: normal;
    }
    .content{
        width: 100%;
        height: 100%;
        padding: 12rpx 12rpx 12rpx 12rpx;
    }

</style>