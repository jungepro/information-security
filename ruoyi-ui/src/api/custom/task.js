import request from '@/utils/request'

// 查询运维事项列表
export function listTask(query) {
  return request({
    url: '/v_custom/task/list',
    method: 'get',
    params: query
  })
}

// 查询运维事项详细
export function getTask(taskId) {
  return request({
    url: '/v_custom/task/' + taskId,
    method: 'get'
  })
}

// 新增运维事项
export function addTask(data) {
  return request({
    url: '/custom/task',
    method: 'post',
    data: data
  })
}

// 修改运维事项
export function updateTask(data) {
  return request({
    url: '/custom/task',
    method: 'put',
    data: data
  })
}

// 删除运维事项
export function delTask(taskId) {
  return request({
    url: '/custom/task/' + taskId,
    method: 'delete'
  })
}

// 导出运维事项
export function exportTask(query) {
  return request({
    url: '/custom/task/export',
    method: 'get',
    params: query
  })
}

// 自定义sql运维事项查询
export function customTTaskSql(query) {
  return request({
    url: '/custom/task/customTTaskSql',
    method: 'get',
    params: query
  })
}
