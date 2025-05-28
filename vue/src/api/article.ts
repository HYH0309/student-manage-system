import login from './request';

export interface Article {
    title: string;
    people: string;
    date: string;
    url: string;
}

// 创建新的文章
const createArticle = async (article: Article) => {
    try {
        return await login.post({
            url: '/articles/add',
            data: article
        });
    } catch (error) {
        console.error('创建文章失败:', error);
        throw error;
    }
};

// 获取所有文章
const getAllArticles = async () => {
    try {
        return await login.get({
            url: '/articles'
        });
    } catch (error) {
        console.error('获取文章列表失败:', error);
        throw error;
    }
};

// 更新文章
const updateArticle = async (id: number, article: Article) => {
    try {
        return await login.put({
            url: `/articles/${id}`,
            data: article
        });
    } catch (error) {
        console.error('更新文章失败:', error);
        throw error;
    }
};

// 删除文章
const deleteArticle = async (id: number) => {
    try {
        return await login.delete({
            url: `/articles/${id}`
        });
    } catch (error) {
        console.error('删除文章失败:', error);
        throw error;
    }
};

// 导出所有 API 方法为一个对象
export default {
    createArticle,
    getAllArticles,
    updateArticle,
    deleteArticle
};
