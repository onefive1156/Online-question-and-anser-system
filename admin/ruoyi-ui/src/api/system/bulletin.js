import request from '@/utils/request'

// 查询通知管理列表
export function listBulletin(query) {
  return request({
    url: '/system/bulletin/list',
    method: 'get',
    params: query
  })
}

// 查询通知管理详细
export function getBulletin(id) {
  return request({
    url: '/system/bulletin/' + id,
    method: 'get'
  })
}

// 新增通知管理
export function addBulletin(data) {
  return request({
    url: '/system/bulletin',
    method: 'post',
    data: data
  })
}

// 修改通知管理
export function updateBulletin(data) {
  return request({
    url: '/system/bulletin',
    method: 'put',
    data: data
  })
}

// 删除通知管理
export function delBulletin(id) {
  return request({
    url: '/system/bulletin/' + id,
    method: 'delete'
  })
}
