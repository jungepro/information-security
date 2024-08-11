import request from '@/utils/request'

// 查询地址列表
export function listAddress(query) {
  return request({
    url: '/mall/address/list',
    method: 'get',
    params: query
  })
}

// 查询地址详细
export function getAddress(addressId) {
  return request({
    url: '/mall/address/' + addressId,
    method: 'get'
  })
}

// 新增地址
export function addAddress(data) {
  return request({
    url: '/mall/address',
    method: 'post',
    data: data
  })
}

// 修改地址
export function updateAddress(data) {
  return request({
    url: '/mall/address',
    method: 'put',
    data: data
  })
}

// 删除地址
export function delAddress(addressId) {
  return request({
    url: '/mall/address/' + addressId,
    method: 'delete'
  })
}

// 导出地址
export function exportAddress(query) {
  return request({
    url: '/mall/address/export',
    method: 'get',
    params: query
  })
}

// 自定义sql地址查询
export function customMallAddressSql(query) {
  return request({
    url: '/mall/address/customMallAddressSql',
    method: 'get',
    params: query
  })
}
