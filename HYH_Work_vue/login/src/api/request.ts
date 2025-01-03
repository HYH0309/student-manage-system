import Service from './config';
import { AxiosRequestConfig, AxiosResponse } from 'axios';

const get = async (config: AxiosRequestConfig): Promise<AxiosResponse> => {
    try {
        const response = await Service({
            ...config,
            method: 'get',
            params: config.data || {}, // 确保 params 是一个对象，即使没有传入 data
        });
        return response;
    } catch (error) {
        // 可以在这里处理错误或抛出更具体的错误
        throw error;
    }
}

const post = async (config: AxiosRequestConfig): Promise<AxiosResponse> => {
    try {
        const response = await Service({
            ...config,
            method: 'post',
            data: config.data,
            headers: {
                'Content-Type': 'application/json', // 确保请求头为 JSON
                ...config.headers // 合并其他请求头
            }
        });
        return response;
    } catch (error) {
        // 在这里处理错误或抛出更具体的错误
        throw error;
    }
}

const put = async (config: AxiosRequestConfig): Promise<AxiosResponse> => {
    try {
        const response = await Service({
            ...config,
            method: 'put',
            data: config.data,
            headers: {
                'Content-Type': 'application/json', // 确保请求头为 JSON
                ...config.headers // 合并其他请求头
            }
        });
        return response;
    } catch (error) {
        // 在这里处理错误或抛出更具体的错误
        throw error;
    }
}

const del = async (config: AxiosRequestConfig): Promise<AxiosResponse> => {
    try {
        const response = await Service({
            ...config,
            method: 'delete',
            params: config.data || {}, // 确保 params 是一个对象，即使没有传入 data
        });
        return response;
    } catch (error) {
        // 在这里处理错误或抛出更具体的错误
        throw error;
    }
}

export default {
    get,
    post,
    put,
    delete: del, // 这里重命名为 delete，保持一致性
}
