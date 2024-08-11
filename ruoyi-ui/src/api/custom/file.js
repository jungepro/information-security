import request from '@/utils/request'

// 查询操作手册列表
export function listFile(query) {
  return request({
    url: '/custom/file/list',
    method: 'get',
    params: query
  })
}

// 查询操作手册详细
export function getFile(fileId) {
  return request({
    url: '/custom/file/' + fileId,
    method: 'get'
  })
}

// 新增操作手册
export function addFile(data) {
  return request({
    url: '/custom/file',
    method: 'post',
    data: data
  })
}

// 修改操作手册
export function updateFile(data) {
  return request({
    url: '/custom/file',
    method: 'put',
    data: data
  })
}

// 删除操作手册
export function delFile(fileId) {
  return request({
    url: '/custom/file/' + fileId,
    method: 'delete'
  })
}

// 导出操作手册
export function exportFile(query) {
  return request({
    url: '/custom/file/export',
    method: 'get',
    params: query
  })
}

// 自定义sql操作手册查询
export function customTFileSql(query) {
  return request({
    url: '/custom/file/customTFileSql',
    method: 'get',
    params: query
  })
}
