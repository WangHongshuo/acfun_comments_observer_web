import axios from 'axios'

const service = axios.create({
  baseURL: import.meta.env.VITE_APP_FRONTEND_BASE_API,
  timeout: 15000,
  headers: { 'Content-Type': 'application/json;charset=utf-8' },
});

service.interceptors.request.use(
  (config) => {
    if (!config.headers) {
      throw new Error('config.headers is not defined')
    }
    return config
  },
  (error) => {
    return Promise.reject(error)
  }
)

service.interceptors.response.use(
  (response) => {
    return response.data
  },
  (error) => {
    console.log('request error: ', error)
  }
)

export default service;
