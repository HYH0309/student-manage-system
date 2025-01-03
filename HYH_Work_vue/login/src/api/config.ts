import axios, { AxiosError } from 'axios';
import { ElMessage } from 'element-plus';

// 创建 Axios 实例
const Service = axios.create({
  baseURL: 'http://localhost:3009/api',
  headers: {
    'Content-Type': 'application/json;charset=UTF-8',
  },
  timeout: 10000,
});

// 获取 Token 函数
const getToken = () => window.sessionStorage.getItem('token');

// 显示错误消息的函数
const handleErrorMessage = (message: string) => {
  ElMessage.error(message);
};

// 请求拦截器
Service.interceptors.request.use(
  (config) => {
    const token = getToken();
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    } else {
      delete config.headers.Authorization;
    }
    return config;
  },
  (error: AxiosError) => {
    handleErrorMessage('请求错误');
    return Promise.reject(error);
  }
);

// 响应拦截器
Service.interceptors.response.use(
  (response) => {
    const res = response.data;

    // 确保响应格式是有效的
    if (res && typeof res.code === 'boolean') { 
      if (res.code) { // 处理成功的响应
        return res; // 返回成功的数据
      } else {
        handleErrorMessage(res.msg || '请求失败');
        return Promise.reject(new Error(res.msg || '请求失败'));
      }
    } else {
      handleErrorMessage('无效的响应格式');
      return Promise.reject(new Error('无效的响应格式'));
    }
  },
  (error: AxiosError) => {
    const { response } = error;

    if (response) {
      const { data } = response;
      handleErrorMessage(data.msg || '响应错误');
    } else {
      handleErrorMessage('响应错误，请检查网络');
    }
    
    // 抛出错误以便后续处理
    return Promise.reject(error);
  }
);

export default Service;
