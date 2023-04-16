import request from '@/utils/request'

// 查询回答管理列表
export function listAnswer(query) {
  return request({
    url: '/system/answer/list',
    method: 'get',
    params: query
  })
}

// 查询回答管理详细
export function getAnswer(id) {
  return request({
    url: '/system/answer/' + id,
    method: 'get'
  })
}

// 新增回答管理
export function addAnswer(data) {
  return request({
    url: '/system/answer',
    method: 'post',
    data: data
  })
}

// 修改回答管理
export function updateAnswer(data) {
  return request({
    url: '/system/answer',
    method: 'put',
    data: data
  })
}

// 删除回答管理
export function delAnswer(id) {
  return request({
    url: '/system/answer/' + id,
    method: 'delete'
  })
}
