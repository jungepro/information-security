import request from '@/utils/request'

// 查询订单商品对照列表
export function listOrderspu(query) {
  return request({
    url: '/mall/orderspu/list',
    method: 'get',
    params: query
  })
}

// 查询订单商品对照详细
export function getOrderspu(orderspuId) {
  return request({
    url: '/mall/orderspu/' + orderspuId,
    method: 'get'
  })
}

// 新增订单商品对照
export function addOrderspu(data) {
  return request({
    url: '/mall/orderspu',
    method: 'post',
    data: data
  })
}

// 修改订单商品对照
export function updateOrderspu(data) {
  return request({
    url: '/mall/orderspu',
    method: 'put',
    data: data
  })
}

// 删除订单商品对照
export function delOrderspu(orderspuId) {
  return request({
    url: '/mall/orderspu/' + orderspuId,
    method: 'delete'
  })
}

// 导出订单商品对照
export function exportOrderspu(query) {
  return request({
    url: '/mall/orderspu/export',
    method: 'get',
    params: query
  })
}

// 自定义sql订单商品对照查询
export function customMallOrderspuSql(query) {
  return request({
    url: '/mall/orderspu/customMallOrderspuSql',
    method: 'get',
    params: query
  })
}
