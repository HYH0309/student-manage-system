import login from './request';

// 异步函数发送 POST 请求
const postRequest = async (url:string, data:any) => {
    try {
        const response = await login.post({
            url: url,
            data: JSON.stringify(data), // 将对象转换为 JSON 字符串形式
            headers: {
                'Content-Type': 'application/json', // 明确设置请求头为 JSON
            },
        });
        return response; // 返回响应数据
    } catch (error) {
        // 错误处理
        console.error('请求失败，URL:', url, error);
        throw new Error('请求失败，请稍后再试'); // 可以定义更详细的错误信息
    }
};

const gradeApi = async (sid:number, role:string) => {
    const url = `/${role}/degrade`; // 使用模板字符串插入角色到 URL 中
    const data = {
        sid:sid
    }
    return await postRequest(url, data); // 传递一个包含 sid 属性的对象形式的数据
};

export default gradeApi;