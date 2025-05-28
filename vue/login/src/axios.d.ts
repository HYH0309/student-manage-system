import axios, { Axios, AxiosResponse, AxiosRequestConfig } from 'axios'
 
declare module 'axios' {
  interface AxiosResponse<T = any> {
    code:any,// 这个地方放属性
    msg: any,
    sid:any
  }
  export function create(config?: AxiosRequestConfig): AxiosInstance
}