<script>
import {testApi} from './api/test.js'
//1. 导入统一身份信息管理模块 https://blog.csdn.net/haidong55/article/details/124559209
import uniIdPageInit from '@/uni_modules/uni-id-pages/init.js'
import uniImUtils from '@/uni_modules/uni-im/common/utils.js'
const uniIdCo = uniCloud.importObject("uni-id-co")
export default {
    onLaunch: async function() {
        console.log('App Launch')
        await uniIdPageInit()
        uniImUtils.init();
    },
  onShow: function () {
    console.log('App Show')
      testApi().then(res=>{
          console.log(res)
      }).catch(err=>{
          console.log(err)
      })
      // uniIdCo.getAccountInfo().then(res=>{
      //     console.log(res)
      // }).catch(err=>{
      //     'console.log(err)'
      // })
  },
  onHide: function () {
    console.log('App Hide')
  },
}
</script>

<style>
/*每个页面公共css */
    page{
        height: 100%;
    }
.fui-list__item {
    position: relative;
}
.fui-cover {
    width: 100%;
    height: 385rpx;
    display: block;
}
.fui-section__title {
    margin-left: 32rpx;
}

.fui-list__title {
    position: absolute;
    left: 0;
    bottom: 0;
    color: #fff;
    font-weight: 500;
    padding: 24rpx 20rpx;
    box-sizing: border-box;
    background: linear-gradient(to bottom, transparent, rgba(0, 0, 0, 0.6));
}
</style>
