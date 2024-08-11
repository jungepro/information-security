import request from '@/utils/request'

// 查询分类列表
export function listCategory(query) {
  return request({
    url: '/temp/category/list',
    method: 'get',
    params: query
  })
}

// 查询分类详细
export function getCategory(categoryId) {
  return request({
    url: '/temp/category/' + categoryId,
    method: 'get'
  })
}

// 新增分类
export function addCategory(data) {
  return request({
    url: '/temp/category',
    method: 'post',
    data: data
  })
}

// 修改分类
export function updateCategory(data) {
  return request({
    url: '/temp/category',
    method: 'put',
    data: data
  })
}

// 删除分类
export function delCategory(categoryId) {
  return request({
    url: '/temp/category/' + categoryId,
    method: 'delete'
  })
}

// 导出分类
export function exportCategory(query) {
  return request({
    url: '/temp/category/export',
    method: 'get',
    params: query
  })
}