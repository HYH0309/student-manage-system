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

const getresouceApi = async(tid:number)=>{
    const url = '/teacher/course'
    const data={
        tid:tid
    }
    return await postRequest(url,data)
}

const updatesouceApi = async(sid:number,oid:number,score:number)=>{
    const url = '/teacher/update_course'
    const data={
        sid:sid,
        oid:oid,
        score:score
    }
    return await postRequest(url,data)
}

export default{
    getresouceApi,
    updatesouceApi
}