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
const infoApi = async (data: string, role: string) => {
    const url = `/${role}/info`; // 使用模板字符串插入角色到 URL 中
    return await postRequest(url, data);
};

//修改的API
const editinfoApi = async (address: string, phone: string, role: string, id:number) => {

    const url = `/${role}/info_edited`;

    const data = {
        address: address,
        phone: phone,
        [role === 'teacher' ? 'tid' : 'sid']: id,
    };

    try {
        const response = await postRequest(url, data);
        console.log('数据更新成功:', response);
        return response; // 可根据返回的响应进行进一步处理
    } catch (error) {
        console.error(error);
        throw new Error('更新信息失败，请稍后再试'); // 错误处理
    }
};

const changePasswordApi = async (pswd:string,role:string,id:number)=>{
    const url = `/${role}/changePassword`;
    const data = {
        pswd:pswd,
        [role === 'teacher' ? 'tid' : 'sid']: id,
    }
    return await postRequest(url,data)
}

export default {
    infoApi,
    editinfoApi,
    changePasswordApi,
};
