import request from '@/utils/request'

// 查询定级列表
export function listDingji(query) {
  return request({
    url: '/custom/dingji/list',
    method: 'get',
    params: query
  })
}

// 查询定级详细
export function getDingji(id) {
  return request({
    url: '/custom/dingji/' + id,
    method: 'get'
  })
}

// 新增定级
export function addDingji(data) {
  return request({
    url: '/custom/dingji',
    method: 'post',
    data: data
  })
}

// 修改定级
export function updateDingji(data) {
  return request({
    url: '/custom/dingji',
    method: 'put',
    data: data
  })
}

// 删除定级
export function delDingji(id) {
  return request({
    url: '/custom/dingji/' + id,
    method: 'delete'
  })
}

// 导出定级
export function exportDingji(query) {
  return request({
    url: '/custom/dingji/export',
    method: 'get',
    params: query
  })
}

// 自定义sql定级查询
export function customTDingjiSql(query) {
  return request({
    url: '/custom/dingji/customTDingjiSql',
    method: 'get',
    params: query
  })
}
