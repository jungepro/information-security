import request from '@/utils/request'

// 查询申请列表
export function listShenqin(query) {
  return request({
    url: '/custom/shenqin/list',
    method: 'get',
    params: query
  })
}

// 查询申请详细
export function getShenqin(id) {
  return request({
    url: '/custom/shenqin/' + id,
    method: 'get'
  })
}

// 新增申请
export function addShenqin(data) {
  return request({
    url: '/custom/shenqin',
    method: 'post',
    data: data
  })
}

// 修改申请
export function updateShenqin(data) {
  return request({
    url: '/custom/shenqin',
    method: 'put',
    data: data
  })
}

// 删除申请
export function delShenqin(id) {
  return request({
    url: '/custom/shenqin/' + id,
    method: 'delete'
  })
}

// 导出申请
export function exportShenqin(query) {
  return request({
    url: '/custom/shenqin/export',
    method: 'get',
    params: query
  })
}

// 自定义sql申请查询
export function customTShenqinSql(query) {
  return request({
    url: '/custom/shenqin/customTShenqinSql',
    method: 'get',
    params: query
  })
}
