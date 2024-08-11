import request from '@/utils/request'

// 查询商品列表
export function listSpu(query) {
  return request({
    url: '/mall/spu/list',
    method: 'get',
    params: query
  })
}

// 查询商品详细
export function getSpu(spuId) {
  return request({
    url: '/mall/spu/' + spuId,
    method: 'get'
  })
}

// 新增商品
export function addSpu(data) {
  return request({
    url: '/mall/spu',
    method: 'post',
    data: data
  })
}

// 修改商品
export function updateSpu(data) {
  return request({
    url: '/mall/spu',
    method: 'put',
    data: data
  })
}

// 删除商品
export function delSpu(spuId) {
  return request({
    url: '/mall/spu/' + spuId,
    method: 'delete'
  })
}

// 导出商品
export function exportSpu(query) {
  return request({
    url: '/mall/spu/export',
    method: 'get',
    params: query
  })
}

// 自定义sql商品查询
export function customMallSpuSql(query) {
  return request({
    url: '/mall/spu/customMallSpuSql',
    method: 'get',
    params: query
  })
}
