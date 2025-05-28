<template>
  <div>
    <el-header>
      <h2>课室管理</h2>
      <el-button type="primary" @click="openDialog">新增课室</el-button>
    </el-header>

    <el-table :data="classrooms" style="width: 100%">
      <el-table-column prop="rid" label="课室Id"></el-table-column>
      <el-table-column prop="capacity" label="容纳人数"></el-table-column>
      <el-table-column label="备注">
        <template #default="scope">
          <span>{{ scope.row.remark }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作">
        <template #default="scope">
          <el-button type="warning" @click="editClassroom(scope.row)">
            编辑
          </el-button>
          <el-button type="danger" @click="confirmDelete(scope.row.rid!)">
            删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog
      v-model="dialogVisible"
      title="课室信息"
      append-to-body
      @close="closeDialog"
    >
      <el-form :model="form">
        <el-form-item label="课室ID" :label-width="formLabelWidth">
          <el-input v-model="form.rid"></el-input>
        </el-form-item>
        <el-form-item label="容纳人数" :label-width="formLabelWidth">
          <el-input v-model="form.capacity" type="number"></el-input>
        </el-form-item>
        <el-form-item label="备注" :label-width="formLabelWidth">
          <el-input v-model="form.remark"></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="closeDialog">取消</el-button>
          <el-button type="primary" @click="saveClassroom">
            {{ isEdit ? '更新' : '创建' }}
          </el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script lang="ts" setup>
import { ref, onMounted } from 'vue'
import * as api from '@/api/classroom' // 导入 API 文件
import { ElMessage, ElMessageBox } from 'element-plus'

interface Classroom {
  rid?: number // optional in case of new classroom
  cname: string
  capacity: number
  remark: string
}

const classrooms = ref<Classroom[]>([])
const dialogVisible = ref(false)
const form = ref<Classroom>({
  rid: undefined,
  cname: '',
  capacity: 0,
  remark: '',
})
const isEdit = ref(false)
const currentClassroomId = ref<number | null>(null)
const formLabelWidth = '80px'

// 获取课室列表
const fetchClassrooms = async () => {
  try {
    const response = await api.default.getAllClassrooms() // 调用 API 获取课室列表
    classrooms.value = response.data
  } catch (error) {
    ElMessage.error('获取课室列表失败: ' + error)
  }
}

// 打开对话框
const openDialog = () => {
  isEdit.value = false
  form.value = { rid: undefined, cname: '', capacity: 0, remark: '' } // Reset form
  dialogVisible.value = true
}

// 关闭对话框
const closeDialog = () => {
  dialogVisible.value = false
  form.value = { rid: undefined, cname: '', capacity: 0, remark: '' } // Reset form
}

// 保存课室信息
const saveClassroom = async () => {
  try {
    if (isEdit.value) {
      await api.default.updateClassroom(currentClassroomId.value!, form.value)
      ElMessage.success('更新成功')
    } else {
      await api.default.createClassroom(form.value)
      ElMessage.success('创建成功')
    }
    closeDialog()
    fetchClassrooms()
  } catch (error) {
    ElMessage.error('保存课室失败: ' + error)
  }
}

// 编辑课室信息
const editClassroom = (classroom: Classroom) => {
  isEdit.value = true
  currentClassroomId.value = classroom.rid!
  form.value = { ...classroom } // Clone object to avoid direct modification
  dialogVisible.value = true
}

// 确认删除课室
const confirmDelete = (id: number) => {
  ElMessageBox.confirm('确定要删除该课室吗?', '警告', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning',
  })
    .then(() => {
      deleteClassroom(id)
    })
    .catch(() => {
      ElMessage.info('已取消删除')
    })
}

// 删除课室
const deleteClassroom = async (id: number) => {
  try {
    await api.default.deleteClassroom(id)
    ElMessage.success('删除成功')
    fetchClassrooms()
  } catch (error) {
    ElMessage.error('删除失败: ' + error)
  }
}

// 组件挂载后获取课室列表
onMounted(() => {
  fetchClassrooms()
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
