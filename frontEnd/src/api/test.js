import request from '../utils/http/request'


export const testApi = () => {
  return request.get('/user/hello/' + '123')
}
