import request from '@/utils/request'
import { QueryResultData } from '@/api'

export function queryCommentApi(aid: string, floorNumber: string) {
  return request<QueryResultData>({
    url: '/comment/query',
    method: 'post',
    data: {
      aid: aid,
      floorNumber: floorNumber
    }
  })
}

