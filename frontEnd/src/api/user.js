import request from "../utils/http/request"

export const login = (data)=>{
    return request(`/user/login/${data}`,{},{method: 'POST'})
}

export const updateUserInfo = (data)=>{
    return request('/user',{student: data}, {method: 'PUT'})
}