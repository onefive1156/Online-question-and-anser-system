import request from '../utils/http/request'


export const testApi = () => {
  return request('/user/hello/123',"",{method: 'GET'})
}
