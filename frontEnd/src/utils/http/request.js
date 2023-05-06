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
    // console.log('%c请求拦截：', ' background:orange', data);

    const token = uni.getStorageSync("token");
    const Authorization = token ? `Bearer ${uni.getStorageSync("token")}` : "";

    if (config.loading) {
        uni.showLoading({
            title: "加载中",
            mask: true
        });
    };

    return new Promise((resolve, reject) => {
        uni.request({
            header: {
                Authorization
            },
            url: baseUrl + path,
            method: config.method,
            data,
            success(response) {
                // console.log('%c响应拦截：', ' background:green', response);
                // if (response.data.code === 3001) {
                //     logout()
                // }
                // if (response.data.code !== 20) {
                //     uni.showToast({
                //         icon: "none",
                //         duration: 4000,
                //         title: response.data.msg
                //     });
                // }

                resolve(response.data);
            },
            fail(err) {
                uni.showToast({
                    icon: "none",
                    title: '服务响应失败'
                });
                console.error(err);
                reject(err);
            },
            complete() {
                uni.hideLoading();
            }
        });
    });
};

