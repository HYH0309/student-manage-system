import login from './request'


const getRequest = async (url: string) => {
    try {
        const response = await login.get({url: url,});
        return response; // 返回响应数据
    } catch (error) {
        // 错误处理
        console.error('请求失败，URL:', url, error);
        throw new Error('请求失败，请稍后再试'); // 可以定义更详细的错误信息
    }
};

const showApi = async (role:string) =>{
    const url = `/${role}/show`;
    return  await  getRequest(url)
}

const approvalApi = async()=>{
    const url = '/approvals'
    return await getRequest(url)
}
export default{
    showApi,
    approvalApi
}