import request from '@/utils/request'

// 查询系统公告列表
export function listNotice(query) {
  return request({
    url: '/custom/notice/list',
    method: 'get',
    params: query
  })
}

// 查询系统公告详细
export function getNotice(noticeId) {
  return request({
    url: '/custom/notice/' + noticeId,
    method: 'get'
  })
}

// 新增系统公告
export function addNotice(data) {
  return request({
    url: '/custom/notice',
    method: 'post',
    data: data
  })
}

// 修改系统公告
export function updateNotice(data) {
  return request({
    url: '/custom/notice',
    method: 'put',
    data: data
  })
}

// 删除系统公告
export function delNotice(noticeId) {
  return request({
    url: '/custom/notice/' + noticeId,
    method: 'delete'
  })
}

// 导出系统公告
export function exportNotice(query) {
  return request({
    url: '/custom/notice/export',
    method: 'get',
    params: query
  })
}

// 自定义sql系统公告查询
export function customTNoticeSql(query) {
  return request({
    url: '/custom/notice/customTNoticeSql',
    method: 'get',
    params: query
  })
}
