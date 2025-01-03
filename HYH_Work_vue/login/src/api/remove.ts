import login from './request';

// 异步函数发送 POST 请求
const postRequest = async (url: string, data: any): Promise<any> => { // 明确函数返回Promise
    try {
        const response = await login.post({
            url: url,
            data: JSON.stringify(data), // 序列化数据到 JSON 字符串
            headers: {
                'Content-Type': 'application/json' // 明确设置请求头为 JSON
            },
        });
        return response; // 返回响应数据
    } catch (error) {
        console.error('请求失败，URL:', url, '错误:', error);
        throw new Error('请求失败，请稍后再试'); // 提供一层客户端错误处理
    }
};

interface RemoveData {
    tid?: number;
    sid?: number;
}

const removeApi = async (id: number, role: 'teacher' | 'student') => {
    const url = `/${role}/remove`;
    const data: RemoveData = {};

    // 使用条件运算符优化结构
    data[role === 'teacher' ? 'tid' : 'sid'] = id;

    return postRequest(url, data);
}

export default {
    removeApi
}
