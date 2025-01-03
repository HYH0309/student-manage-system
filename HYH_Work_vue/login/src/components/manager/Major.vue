<template>
  <div>
    <el-header>
      <h2>专业管理</h2>
      <el-button type="primary" @click="openDialog">新增专业</el-button>
    </el-header>

    <el-table :data="majors" style="width: 100%">
      <el-table-column prop="mname" label="专业名称"></el-table-column>
      <el-table-column prop="mdept" label="所属学院"></el-table-column>
      <el-table-column label="操作">
        <template #default="scope">
          <el-button type="warning" @click="editMajor(scope.row)"
            >编辑</el-button
          >
          <el-button type="danger" @click="confirmDelete(scope.row.mid!)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>

    <el-dialog
      v-model="dialogVisible"
      title="专业信息"
      append-to-body
      @close="closeDialog"
    >
      <el-form :model="form">
        <el-form-item label="专业名称" :label-width="formLabelWidth">
          <el-input v-model="form.mname"></el-input>
        </el-form-item>
        <el-form-item label="所属学院" :label-width="formLabelWidth">
          <el-input v-model="form.mdept"></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="closeDialog">取消</el-button>
          <el-button type="primary" @click="saveMajor">{{
            isEdit ? '更新' : '创建'
          }}</el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script lang="ts" setup>
import { ref, onMounted } from 'vue'
import * as api from '@/api/major' // 导入 API 文件
import { ElMessage, ElMessageBox } from 'element-plus'

interface Major {
  mid?: number // optional in case of new major
  mname: string
  mdept: string
}

const majors = ref<Major[]>([])
const dialogVisible = ref(false)
const form = ref<Major>({ mname: '', mdept: '' })
const isEdit = ref(false)
const currentMajorId = ref<number | null>(null)
const formLabelWidth = '80px'

// 获取 majors 列表
const fetchMajors = async () => {
  try {
    const response = await api.default.getAllMajors()
    majors.value = response.data
  } catch (error) {
    ElMessage.error('获取专业列表失败: ' + error)
  }
}

// 打开对话框
const openDialog = () => {
  isEdit.value = false
  form.value = { mname: '', mdept: '' } // Reset form
  dialogVisible.value = true
}

// 关闭对话框
const closeDialog = () => {
  dialogVisible.value = false
  form.value = { mname: '', mdept: '' } // Reset form
}

// 保存专业信息
const saveMajor = async () => {
  try {
    if (isEdit.value) {
      await api.default.updateMajor(currentMajorId.value!, form.value)
      ElMessage.success('更新成功')
    } else {
      await api.default.createMajor(form.value)
      ElMessage.success('创建成功')
    }
    closeDialog()
    fetchMajors()
  } catch (error) {
    ElMessage.error('保存专业失败: ' + error)
  }
}

// 编辑专业信息
const editMajor = (major: Major) => {
  isEdit.value = true
  currentMajorId.value = major.mid!
  form.value = { ...major } // Clone object to avoid direct modification
  dialogVisible.value = true
}

// 确认删除专业
const confirmDelete = (id: number) => {
  ElMessageBox.confirm('确定要删除该专业吗?', '警告', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning',
  })
    .then(() => {
      deleteMajor(id)
    })
    .catch(() => {
      ElMessage.info('已取消删除')
    })
}

// 删除专业
const deleteMajor = async (id: number) => {
  try {
    await api.default.deleteMajor(id)
    ElMessage.success('删除成功')
    fetchMajors()
  } catch (error) {
    ElMessage.error('删除失败: ' + error)
  }
}

// 组件挂载后获取专业列表
onMounted(() => {
  fetchMajors()
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
