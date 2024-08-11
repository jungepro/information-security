import request from '@/utils/request'

// 查询收藏列表
export function listFavorite(query) {
  return request({
    url: '/mall/favorite/list',
    method: 'get',
    params: query
  })
}

// 查询收藏详细
export function getFavorite(favoriteId) {
  return request({
    url: '/mall/favorite/' + favoriteId,
    method: 'get'
  })
}

// 新增收藏
export function addFavorite(data) {
  return request({
    url: '/mall/favorite',
    method: 'post',
    data: data
  })
}

// 修改收藏
export function updateFavorite(data) {
  return request({
    url: '/mall/favorite',
    method: 'put',
    data: data
  })
}

// 删除收藏
export function delFavorite(favoriteId) {
  return request({
    url: '/mall/favorite/' + favoriteId,
    method: 'delete'
  })
}

// 导出收藏
export function exportFavorite(query) {
  return request({
    url: '/mall/favorite/export',
    method: 'get',
    params: query
  })
}

// 自定义sql收藏查询
export function customMallFavoriteSql(query) {
  return request({
    url: '/mall/favorite/customMallFavoriteSql',
    method: 'get',
    params: query
  })
}
