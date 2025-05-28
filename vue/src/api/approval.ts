import login from './request';

// 异步函数发送 POST 请求
const postRequest = async (url: string, data: any) => {
    try {
        const response = await login.post({
            url: url,
            data: JSON.stringify(data), // 将数据序列化为 JSON 字符串
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

// 根据角色参数化API
const approvalApi = async (sid:number,type:string,title:string,reason:string, role: string) => {
    const url = `/${role}/approvalFrom`; // 使用模板字符串插入角色到 URL 中
    const data = {
        sid: sid, // 从 Cookie 中获取的学生ID，确保有后备值
        type: type,
        title: title,
        reason: reason
    }
    return await postRequest(url, data);
};
export default{
    approvalApi
}