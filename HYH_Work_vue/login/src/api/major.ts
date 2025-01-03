import login from './request';

export interface Major {
    mname: string;
    mdept: string;
}

// 创建新的专业
const createMajor = async (major: Major) => {
    try {
        return await login.post({
            url: '/majors/add',
            data: major
        });
    } catch (error) {
        console.error('创建专业失败:', error);
        throw error;
    }
};

// 获取所有专业
const getAllMajors = async () => {
    try {
        return await login.get({
            url: '/majors'
        });
    } catch (error) {
        console.error('获取专业列表失败:', error);
        throw error;
    }
};

// 更新专业
const updateMajor = async (mid: number, major: Major) => {
    try {
        return await login.put({
            url: `/majors/${mid}`,
            data: major
        });
    } catch (error) {
        console.error('更新专业失败:', error);
        throw error;
    }
};

// 删除专业
const deleteMajor = async (mid: number) => {
    try {
        return await login.delete({
            url: `/majors/${mid}`
        });
    } catch (error) {
        console.error('删除专业失败:', error);
        throw error;
    }
};

// 导出所有 API 方法为一个对象
export default {
    createMajor,
    getAllMajors,
    updateMajor,
    deleteMajor
};
