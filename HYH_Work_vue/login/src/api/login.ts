import login from './request';

// 定义数据类型
export interface User {
    username: string;
    password: string;
    captcha:string;
}

export interface Result {
    code: boolean; 
    msg: string ; 
}

// 封装的 POST 请求方法
const postRequest = async (url: string, data: any) => {
    try {
        const response = await login.post({
            url: url,
            data: JSON.stringify(data), // 将data转换为JSON字符串
            headers: {
                'Content-Type': 'application/json', // 明确指定请求头为JSON
            },
        });
        return response; // 返回响应的数据
    } catch (error) {
        // 处理错误
        console.error(`请求失败: ${url}`, error);
        throw new Error('请求失败，请稍后再试'); // 可以定义更具体的错误信息
    }
};

// 发送登录请求
const loginApi = async (data: User) => {
    return await postRequest('/login', data);
}

// 发送注册请求
const registerApi = async (data: User) => {
    return await postRequest('/register', data);
}

//获得出验证码
// 导出 API 方法
export default {
    loginApi,
    registerApi,
};
