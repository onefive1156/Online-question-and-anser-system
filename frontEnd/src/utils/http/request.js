import axios from "axios";
import { UniAdapter } from "uniapp-axios-adapter"


const request = axios.create({
    baseURL: "http://localhost:8080",
    timeout: 10000,
    adapter: UniAdapter, // 指定适配器
});


request.interceptors.request.use((config) => {
    //带上token
    config.headers["Authorization"] = "token";
    return config;
});

request.interceptors.response.use((response) => {
    // 统一处理响应,返回Promise以便链式调用
    if (response.status === 200) {
        const { data } = response;
        if (data && data.code === 200) {
            return Promise.resolve(data);
        } else {
            return Promise.reject(data);
        }
    } else {
        return Promise.reject(response);
    }
});

export default request