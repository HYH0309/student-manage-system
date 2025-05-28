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

//
const scheduleApi = async (year:string,term:string,cname:string,week:number,role:string)=>{
    const url = `/${role}/schedule`;
    const data = {
        year:year,
        term:term,
        cname:cname,
        weekno:week
    };
    return await postRequest(url,data);
}
const tscheduleApi = async (year:string,term:string,tid:number,week:number,role:string)=>{
    const url = `/${role}/schedule`;
    const data = {
        year:year,
        term:term,
        tid:tid,
        weekno:week
    };
    return await postRequest(url,data);
}
export default {
    scheduleApi,
    tscheduleApi
};
