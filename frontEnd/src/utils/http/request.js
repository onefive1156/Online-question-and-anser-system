// import axios from "axios";
// import { UniAdapter } from "uniapp-axios-adapter"
//
// const uniIdCo = uniCloud.importObject("uni-id-co")
// const request = axios.create({
//     baseURL: "http://localhost:8080",
//     timeout: 10000,
//     adapter: UniAdapter, // 指定适配器
// });
//
//
// request.interceptors.request.use((config) => {
//     //带上token
//     // await uniIdCo.getAccountInfo().then(res =>{
//     //     console.log(res)
//     // }).catch(err=>{
//     //     console.log(err)
//     // })
//     config.headers.authorization = '123'
//     // console.log(res)
//     return config
//
// });
//
// request.interceptors.response.use((response) => {
//     // 统一处理响应,返回Promise以便链式调用
//     if (response.status === 200) {
//         const { data } = response
//         if (data && data.code === 200) {
//             return Promise.resolve(data)
//         } else {
//             return Promise.reject(data)
//         }
//     } else {
//         return Promise.reject(response)
//     }
// });
//
// export default request




const defaults = {
    method: "POST",
    loading: true
}
const baseUrl = 'http://localhost:8080'
// 全局请求封装
export default (path, data = {}, config = defaults) => {
    if (config.loading) {
        uni.showLoading({
            title: "加载中",
            mask: true
        });
    };
    const token = uniCloud.importObject("token")
    return token.checkToken().then(res=>{
        if(res.status !== 0){
            uni.showToast({
                title: '用户校验失败请重新登录',
                icon: 'none',

            })
            return new Error('用户校验失败')
        }
        return new Promise((resolve, reject)=>{
            return uni.request({
                url: baseUrl + path,
                method: config.method,
                data,
                success(response) {
                    resolve(response.data)
                },
                fail(err) {
                    uni.showToast({
                        icon: "none",
                        title: '服务响应失败'
                    });
                    console.error(err);
                    reject(err)
                },
                complete() {
                    uni.hideLoading();
                }
            })
        })
    }).catch(err=>{
        console.log(err)

    })
    // return new Promise((resolve, reject) => {
    //     resolve(token.checkToken())
    // }).then(res=>{
    //     // console.log(res.status === 0)
    //
    //     return new Promise((resolve, reject) => {
    //         return uni.request({
    //             url: baseUrl + path,
    //             method: config.method,
    //             data,
    //             success(response) {
    //                 resolve(response.data)
    //             },
    //             fail(err) {
    //                 uni.showToast({
    //                     icon: "none",
    //                     title: '服务响应失败'
    //                 });
    //                 console.error(err);
    //                 reject(err)
    //             },
    //             complete() {
    //                 uni.hideLoading();
    //             }
    //         })
    //     })
    // }).catch(err=>{
    //     console.log(err)
    // })
};

