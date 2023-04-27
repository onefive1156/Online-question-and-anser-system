<template>
  <view class="content">
<!--      <view class="content-top">-->
<!--          <fui-text :text="title" type="primary" :size="28"></fui-text>-->
<!--      </view>-->
      <view class="side-swiper">
          <swiper class="index-swiper" :autoplay="true" :indicator-dots="true" interval="3000"
                  duration="500" indicator-color="rgba(0,0,0,0.3)" circular="true">
              <swiper-item v-for="item in swiperItem" :key="item">
                  <image :src="item"></image>
              </swiper-item>
          </swiper>
      </view>
      <fui-text text="推荐课程" :size="42" fontWeight="600" class="title"></fui-text>
      <view class="content-bottom">
          <fui-card  v-for="item in courseList" :key="item"
                     :margin="['24rpx', '32rpx']" :padding="['20rpx', '20rpx']"
                     imageRadius="50%" title="课程" background="rgba(0,0,0,0.03)"
                     tag="23小时前" :headerLine="false" showBorder
          @click="toCourseDetails">
              <view class="fui-list__item">
                  <image class="fui-cover" :src="item" mode="widthFix">
                  </image>
                  <view class="fui-list__title">课程介绍</view>
              </view>
          </fui-card>
<!--          <fui-card  title="标题文字" >-->
<!--              <view class="fui-card__content">这是一个基础卡片的示例，此处为自定义内容区域，自行控制内容样式。</view>-->
<!--          </fui-card>-->
      </view>
  </view>
</template>

<script setup>
// export default {
//   data() {
//     return {
//       title: '欢迎使用在线教育平台',
//     }
//   },
//   onLoad() {},
//   methods: {},
// }
// import ref from 'vue'
import { ref } from 'vue'
import {store,mutations} from '../../uni_modules/uni-id-pages/common/store'
const title = ref('经典课程')
const swiperItem = ref(['http://localhost:8080/swiper/1.jpg', 'http://localhost:8080/swiper/2.jpg', 'http://localhost:8080/swiper/3.jpg'])
const courseList = ref(['http://localhost:8080/course/1.jpg', 'http://localhost:8080/course/2.jpg', 'http://localhost:8080/course/3.jpg'])
const toCourseDetails = ()=>{
    uni.navigateTo({
        url: '/pages/courseDetails/index'
    })
}
console.log(store?.userInfo?.avatar_file?.url)
console.log(store)
</script>

<style lang="scss">

.content {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: flex-start;
    width: 100%;
    padding: 24rpx 24rpx;
    /*padding-right: 12rpx;*/
    box-sizing: border-box;

    .title{
        align-self: flex-start;
    }
  .side-swiper{
      width: 100%;
      border-radius: 12rpx;
      overflow: hidden;
      .index-swiper{
          width: 100%;

          /*height: 400 rpx;*/
          image{
              width: 100%;
              /*height: 100%;*/
          }
      }
  }
    .content-bottom{
        width: 95%;
        /*fui-card{*/
        /*    view{*/
        /*        margin-bottom: 12rpx;*/
        /*    }*/
        /*}*/
    }
}


.fui-card__body{
    box-sizing: border-box;
    /*padding: 10px 10px;*/
    height: 320rpx;
}
</style>
