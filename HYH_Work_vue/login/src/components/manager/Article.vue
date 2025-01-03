<template>
  <div>
    <el-header>
      <h2>文章管理</h2>
      <el-button type="primary" @click="openDialog">新增文章</el-button>
    </el-header>

    <el-table :data="articles" style="width: 100%">
      <el-table-column prop="id" label="文章ID"></el-table-column>
      <el-table-column prop="title" label="标题"></el-table-column>
      <el-table-column prop="people" label="作者"></el-table-column>
      <el-table-column prop="date" label="日期"></el-table-column>
      <el-table-column prop="url" label="链接"></el-table-column>
      <el-table-column label="操作">
        <template #default="scope">
          <el-button type="warning" @click="editArticle(scope.row)">
            编辑
          </el-button>
          <el-button type="danger" @click="confirmDelete(scope.row.id!)">
            删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog
      v-model="dialogVisible"
      title="文章信息"
      append-to-body
      @close="closeDialog"
    >
      <el-form :model="form">
        <el-form-item label="文章ID" :label-width="formLabelWidth">
          <el-input v-model="form.id" disabled></el-input>
        </el-form-item>
        <el-form-item label="标题" :label-width="formLabelWidth">
          <el-input v-model="form.title"></el-input>
        </el-form-item>
        <el-form-item label="作者" :label-width="formLabelWidth">
          <el-input v-model="form.people"></el-input>
        </el-form-item>
        <el-form-item label="日期" :label-width="formLabelWidth">
          <el-input v-model="form.date"></el-input>
        </el-form-item>
        <el-form-item label="链接" :label-width="formLabelWidth">
          <el-input v-model="form.url"></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="closeDialog">取消</el-button>
          <el-button type="primary" @click="saveArticle">
            {{ isEdit ? '更新' : '创建' }}
          </el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script lang="ts" setup>
import { ref, onMounted } from 'vue'
import * as api from '@/api/article' // 导入文章 API 文件
import { ElMessage, ElMessageBox } from 'element-plus'

interface Article {
  id: number
  title: string
  people: string
  date: string
  url: string
}

const articles = ref<Article[]>([])
const dialogVisible = ref(false)
const form = ref<Article>({ id: 0, title: '', people: '', date: '', url: '' })
const isEdit = ref(false)
const formLabelWidth = '80px'

// 获取文章列表
const fetchArticles = async () => {
  try {
    const response = await api.default.getAllArticles() // 调用 API 获取文章列表
    articles.value = response.data
  } catch (error) {
    ElMessage.error('获取文章列表失败: ' + error)
  }
}

// 打开对话框
const openDialog = () => {
  isEdit.value = false
  form.value = { id: 0, title: '', people: '', date: '', url: '' } // Reset form
  dialogVisible.value = true
}

// 关闭对话框
const closeDialog = () => {
  dialogVisible.value = false
  form.value = { id: 0, title: '', people: '', date: '', url: '' } // Reset form
}

// 保存文章信息
const saveArticle = async () => {
  try {
    if (isEdit.value) {
      await api.default.updateArticle(form.value.id, form.value)
      ElMessage.success('更新成功')
    } else {
      await api.default.createArticle(form.value)
      ElMessage.success('创建成功')
    }
    closeDialog()
    fetchArticles()
  } catch (error) {
    ElMessage.error('保存文章失败: ' + error)
  }
}

// 编辑文章信息
const editArticle = (article: Article) => {
  isEdit.value = true
  form.value = { ...article } // Clone object to avoid direct modification
  dialogVisible.value = true
}

// 确认删除文章
const confirmDelete = (id: number) => {
  ElMessageBox.confirm('确定要删除该文章吗?', '警告', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning',
  })
    .then(() => {
      deleteArticle(id)
    })
    .catch(() => {
      ElMessage.info('已取消删除')
    })
}

// 删除文章
const deleteArticle = async (id: number) => {
  try {
    await api.default.deleteArticle(id)
    ElMessage.success('删除成功')
    fetchArticles()
  } catch (error) {
    ElMessage.error('删除失败: ' + error)
  }
}

// 组件挂载后获取文章列表
onMounted(() => {
  fetchArticles()
})
</script>

<style scoped>
.el-dialog {
  width: 70%; /* 对话框的宽度，你可以根据需要调整 */
  min-height: 300px; /* 设置最小高度，确保即使内容为空也会有高度 */
  margin: auto; /* 对话框中心化 */
}

.el-header {
  margin-bottom: 20px;
}
</style>
