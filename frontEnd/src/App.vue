<script>
import {testApi} from './api/test'
export default {
  onLaunch: function () {
    console.log('App Launch')
    testApi().then(res => {
        console.log(res)
    }).catch(err=>{
        console.log(err)
    })
  },
  onShow: function () {
    console.log('App Show')
  },
  onHide: function () {
    console.log('App Hide')
  },
}
</script>

<style>
/*每个页面公共css */
</style>
