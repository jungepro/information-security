import request from '@/utils/request'

// 查询操作日志列表
export function listOperate(query) {
  return request({
    url: '/v_custom/operate/list',
    method: 'get',
    params: query
  })
}

// 查询操作日志详细
export function getOperate(operateId) {
  return request({
    url: '/v_custom/operate/' + operateId,
    method: 'get'
  })
}

// 新增操作日志
export function addOperate(data) {
  return request({
    url: '/custom/operate',
    method: 'post',
    data: data
  })
}

// 修改操作日志
export function updateOperate(data) {
  return request({
    url: '/custom/operate',
    method: 'put',
    data: data
  })
}

// 删除操作日志
export function delOperate(operateId) {
  return request({
    url: '/custom/operate/' + operateId,
    method: 'delete'
  })
}

// 导出操作日志
export function exportOperate(query) {
  return request({
    url: '/custom/operate/export',
    method: 'get',
    params: query
  })
}

// 自定义sql操作日志查询
export function customTOperateSql(query) {
  return request({
    url: '/custom/operate/customTOperateSql',
    method: 'get',
    params: query
  })
}
