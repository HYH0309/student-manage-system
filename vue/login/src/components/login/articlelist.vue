<template>
  <div class="article-list">
    <el-header>
      <h2>文章列表</h2>
    </el-header>

    <div class="article-container">
      <div class="article-header">
        <span class="article-title">标题</span>
        <span class="article-author">作者</span>
      </div>
      <div v-for="article in articles" :key="article.id" class="article-item">
        <span class="article-title">{{ article.title }}</span>
        <span class="article-author">{{ article.people }}</span>
      </div>
    </div>

    <el-loading v-if="loading" />
  </div>
</template>

<script lang="ts" setup>
import { ref, onMounted } from 'vue'
import * as api from '@/api/article' // 导入文章 API 文件
import { ElMessage } from 'element-plus'

interface Article {
  id: number
  title: string
  people: string
  date: string
  url: string
}

const articles = ref<Article[]>([])
const loading = ref(false)

// 获取所有文章
const fetchArticles = async () => {
  loading.value = true
  try {
    const response = await api.default.getAllArticles() // 确保此 API 方法正确返回文章列表
    articles.value = response.data // 假设响应结构是这样
  } catch (error) {
    ElMessage.error('获取文章列表失败: ' + error)
  } finally {
    loading.value = false
  }
}

// 组件挂载后自动获取文章列表
onMounted(fetchArticles)
</script>

<style scoped>
.article-list {
  padding: 20px;
}

.el-header {
  margin-bottom: 20px;
}

.article-container {
  display: flex;
  flex-direction: column;
}

.article-header {
  display: flex;
  font-weight: bold;
  margin-bottom: 10px;
}

.article-item {
  display: flex;
  justify-content: space-between;
  padding: 10px 0;
  border-bottom: 1px solid #eaeaea;
}

.article-title {
  flex: 1;
}

.article-author {
  flex: 0 0 150px; /* 设定固定宽度或最小宽度 */
  text-align: right;
}
</style>
