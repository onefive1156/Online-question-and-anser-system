import request from '@/utils/request'

// 查询问题管理列表
export function listProblem(query) {
  return request({
    url: '/system/problem/list',
    method: 'get',
    params: query
  })
}

// 查询问题管理详细
export function getProblem(id) {
  return request({
    url: '/system/problem/' + id,
    method: 'get'
  })
}

// 新增问题管理
export function addProblem(data) {
  return request({
    url: '/system/problem',
    method: 'post',
    data: data
  })
}

// 修改问题管理
export function updateProblem(data) {
  return request({
    url: '/system/problem',
    method: 'put',
    data: data
  })
}

// 删除问题管理
export function delProblem(id) {
  return request({
    url: '/system/problem/' + id,
    method: 'delete'
  })
}
