<template>
<view class="content">
    <view class="content-top">
        <view class="side-content-top">
            <view class="content-avatar">
                <fui-avatar mode="heightFix" @click="toLogin" radius="12" width="120" class="col-center" shape="square" :src="avatarUrl"></fui-avatar>
                <view class="personal_info">
                    <view class="personal_info_top">
                        <fui-text :text="userName" :size=32 :fontWeight="800"></fui-text>
                    </view>
                    <view class="personal_info_bottom">
                        <fui-text :text="collage" color="#333333" :size=24 ></fui-text>
                        <fui-text :text="grade" :size=24 color="#333333" ></fui-text>
                    </view>
                </view>
            </view>
            <view class="content-info">
                <view class="info-item">
                    <fui-text text="回答" align="center" :size=32 :fontWeight="800"></fui-text>
                    <fui-text :text="ansNum" align="center" :size=28 :fontWeight="400" color="#333333"></fui-text>
                </view>
                <view class="info-item">
                    <fui-text text="问题" align="center" :size=32 :fontWeight="800"></fui-text>
                    <fui-text :text="quesNum" align="center" :size=28 :fontWeight="400" color="#333333"></fui-text>
                </view>
                <view class="info-item">
                    <fui-text text="收藏" align="center" :size=32 :fontWeight="800"></fui-text>
                    <fui-text :text="favorites" align="center" :size=28 :fontWeight="400" color="#333333"></fui-text>
                </view>
                <view class="info-item">
                    <fui-text text="关注" align="center" :size=32 :fontWeight="800"></fui-text>
                    <fui-text :text="focusNum" align="center" :size=28 :fontWeight="400" color="#333333"></fui-text>
                </view>
            </view>
        </view>

    </view>
    <view class="content-body">
        <fui-list radius="24rpx">
            <fui-list-cell arrow :topBorder="true">公告</fui-list-cell>
            <fui-list-cell arrow :topBorder="true" @click="toPersonalDetails">我的详细信息</fui-list-cell>
        </fui-list>
    </view>
</view>
</template>

<script setup>
    import { ref } from 'vue'
    import {store,mutations} from '../../uni_modules/uni-id-pages/common/store'
    const uniIdCo = uniCloud.importObject("uni-id-co")
    const userName = ref( store.hasLogin ? store.userInfo.nickname : '未登录')
    const grade = ref('大四')
    const collage = ref('计算机科学与技术学院')
    const ansNum = ref(0)
    const quesNum = ref(0)
    const favorites = ref(0)
    const focusNum = ref(0)
    const avatarUrl = ref( store.hasLogin ? store.userInfo?.avatar_file.url : 'http://localhost:8080/swiper/1.jpg')
    // uniIdCo.getAccountInfo().then(res=>{
    //     console.log(res)
    // }).catch(err=>{
    //     console.log(err)
    // })
    const toLogin = ()=>{
        uni.navigateTo({
            "url":"/uni_modules/uni-id-pages/pages/login/login-withoutpwd?type=weixin"
        })
    }
    const toPersonalDetails = ()=>{
        //uni_modules/uni-id-pages/pages/userinfo/userinfo
        uni.navigateTo({
            "url":"/uni_modules/uni-id-pages/pages/userinfo/userinfo"
        })
    }
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
    .content{
        width: 100vw;
        height: 100%;
        background-color: rgba(0, 0, 0, 0.05);
        display: flex;
        flex-direction: column;
        padding: 10rpx 24rpx;
        box-sizing: border-box;
        justify-content: space-between;
        .content-top{
            width: 100%;
            height: 35vh;
            /*background-color: #3d9933;*/
            .side-content-top{
                width: 100%;
                height: 100%;
                background-color: #fff;
                border-radius: 24rpx;
                display: flex;
                flex-direction: column;
                padding: 12rpx 24rpx;
                box-sizing: border-box;
                .content-avatar{
                    width: 100%;
                    height: 50%;
                    display: flex;
                    justify-content: space-between;
                    align-items: center;
                    .personal_info{
                        height: 120rpx;
                        flex-grow: 0.9;
                        display: flex;
                        flex-direction: column;
                        .personal_info_top{
                            width: 100%;
                            height: 50%;
                        }
                        .personal_info_bottom{
                            width: 100%;
                            height: 50%;
                            display: flex;
                            fui-text{
                                margin-right: 12rpx;
                            }
                        }
                    }
                }
                .content-info{
                    width: 100%;
                    height: 50%;
                    display: flex;
                    justify-content: space-around;
                    .info-item{
                        width: 20%;
                        height: 80%;
                        display: flex;
                        flex-direction: column;
                        justify-content: space-around;
                        fui-text{
                            text-align: center;
                        }
                    }
                }
            }
        }
        .content-body{
            width: 100%;
            height: 60vh;
            /*background-color: red;*/
            border-radius: 24rpx;
            /*padding: 12rpx 12rpx;*/
            box-sizing: border-box;
        }

    }
    .col-center{
        display: flex;
        align-items: center;
    }
</style>