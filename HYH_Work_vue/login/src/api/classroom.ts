import login from './request';

export interface Classroom {
    cname: string;
    capacity: number;
    remark: string;
}

// 创建新的课室
const createClassroom = async (classroom: Classroom) => {
    try {
        return await login.post({
            url: '/classrooms/add',
            data: classroom
        });
    } catch (error) {
        console.error('创建课室失败:', error);
        throw error;
    }
};

// 获取所有课室
const getAllClassrooms = async () => {
    try {
        return await login.get({
            url: '/classrooms'
        });
    } catch (error) {
        console.error('获取课室列表失败:', error);
        throw error;
    }
};

// 更新课室
const updateClassroom = async (cid: number, classroom: Classroom) => {
    try {
        return await login.put({
            url: `/classrooms/${cid}`,
            data: classroom
        });
    } catch (error) {
        console.error('更新课室失败:', error);
        throw error;
    }
};

// 删除课室
const deleteClassroom = async (cid: number) => {
    try {
        return await login.delete({
            url: `/classrooms/${cid}`
        });
    } catch (error) {
        console.error('删除课室失败:', error);
        throw error;
    }
};

// 导出所有 API 方法为一个对象
export default {
    createClassroom,
    getAllClassrooms,
    updateClassroom,
    deleteClassroom
};
