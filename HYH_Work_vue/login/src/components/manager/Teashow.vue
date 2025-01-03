<template>
  <div class="table-wrapper">
    <!-- 搜索框 -->
    <div class="search">
      <!-- 搜索框 -->
      <el-input
        v-model="searchQuery"
        placeholder="搜索老师..."
        style="width: 300px"
      ></el-input>
      <el-button type="primary">导入老师信息</el-button>
    </div>
    <el-table :data="filteredTeachers" style="width: 100%">
      <el-table-column prop="tid" label="工号" width="180"></el-table-column>
      <el-table-column prop="tname" label="姓名" width="180"></el-table-column>
      <el-table-column
        prop="tstatus"
        label="状态"
        width="180"
      ></el-table-column>
      <el-table-column width="180">
        <template #default="{ row }">
          <el-button type="primary" @click.stop="handleShowDialog(row)"
            >详情</el-button
          >
        </template>
      </el-table-column>
      <el-table-column width="180">
        <template #default="{ row }">
          <el-button type="danger" @click.stop="removeTeacher(row)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
  </div>

  <el-dialog v-model="dialogVisible" title="老师详情">
    <el-form :model="currentTeacher">
      <el-form-item label="姓名">
        <el-input v-model="currentTeacher.tname" disabled></el-input>
      </el-form-item>
      <el-form-item label="性别">
        <el-input v-model="currentTeacher.tsex" disabled></el-input>
      </el-form-item>
      <el-form-item label="状态">
        <el-input v-model="currentTeacher.tstatus" disabled></el-input>
      </el-form-item>
      <el-form-item label="地址">
        <el-input
          v-model="currentTeacher.address"
          :disabled="!editAddress"
        ></el-input>
      </el-form-item>
      <el-form-item label="电话">
        <el-input
          v-model="currentTeacher.phone"
          :disabled="!editPhone"
        ></el-input>
      </el-form-item>
    </el-form>
    <template #footer>
      <div class="dialog-footer">
        <el-button type="primary" @click="toggleEditMode">
          {{ editAddress || editPhone ? '保存' : '编辑' }}
        </el-button>
        <el-button type="danger" @click="resetPassword">重置密码</el-button>
      </div>
    </template>
  </el-dialog>
</template>

<script>
import { ref, onMounted, computed } from 'vue'
import showApi from '@/api/show'
import infoAPI from '@/api/info'
import { ElMessage, ElMessageBox } from 'element-plus'
import removeApi from '@/api/remove'

export default {
  setup() {
    const searchQuery = ref('')
    const Teachers = ref([])
    const currentTeacher = ref({})
    const dialogVisible = ref(false)
    const editAddress = ref(false)
    const editPhone = ref(false)

    const fetchTeachers = async () => {
      try {
        const response = await showApi.showApi('teacher')
        if (response && response.code) {
          Teachers.value = response.data
        } else {
          console.error('Failed to fetch Teachers or incorrect data structure')
        }
      } catch (error) {
        console.error('Error fetching Teachers:', error)
      }
    }
    const filteredTeachers = computed(() => {
      if (!searchQuery.value) {
        return Teachers.value
      }
      return Teachers.value.filter((teacher) =>
        teacher.tname.toLowerCase().includes(searchQuery.value.toLowerCase()),
      )
    })
    const handleShowDialog = (row) => {
      currentTeacher.value = JSON.parse(JSON.stringify(row))
      dialogVisible.value = true
    }
    const removeTeacher = async (row) => {
      ElMessageBox.confirm(
        `确定要删除这位工号为${row.tid}姓名为${row.tname}的老师吗?`,
        '警告',
        {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
        },
      )
        .then(async () => {
          // 注意这里使用 async 来处理异步函数
          try {
            // 确保这里使用 await 来等待异步操作的结果
            const res = await removeApi.removeApi(row.tid, 'teacher')
            // 检查响应代码来决定展示成功或错误信息
            if (res.code) {
              // 这里假设返回值中存在一个code来判断操作是否成功
              ElMessage.success(res.msg)
            } else {
              ElMessage.error(res.msg)
            }
            fetchTeachers()
          } catch (error) {
            // 如果API调用失败，捕获错误并显示
            ElMessage.error('操作失败: ' + error.message)
          }
        })
        .catch(() => {
          // 用户取消操作，显示取消消息
          ElMessage.info('已取消删除')
        })
    }
    const toggleEditMode = async (row) => {
      if (!editAddress.value && !editPhone.value) {
        // 开启编辑模式
        editAddress.value = true
        editPhone.value = true
      } else {
        console.log(row.value)
        // 保存修改后的地址和电话信息
        const res = await infoAPI.editinfoApi(
          row.address,
          row.phone,
          'teacher',
          row.tid,
        )
        if (res.code) {
          ElMessage.success(res.msg)
        } else {
          ElMessage.error(res.msg)
        }
        // 关闭编辑模式
        editAddress.value = false
        editPhone.value = false
      }
    }
    const resetPassword = () => {
      /* Logic for resetting password */
    }

    onMounted(() => fetchTeachers())

    return {
      filteredTeachers,
      editAddress,
      editPhone,
      searchQuery,
      Teachers,
      currentTeacher,
      dialogVisible,
      removeTeacher,
      handleShowDialog, // For handling button click inside table row.
      toggleEditMode,
      resetPassword,
    }
  },
}
</script>

<style scoped>
.table-wrapper {
  width: 100%; /* 调整表格容器宽度填满可用空间 */
  max-width: 900px; /* 或者你可以设置一个最大宽度 */
  margin: auto; /* 水平居中 */
}

.seacher {
  display: flex;
  align-items: center;
  gap: 10px;
  margin-bottom: 20px;
}

.el-dialog {
  width: 70%; /* 对话框的宽度，你可以根据需要调整 */
  min-height: 300px;
  margin: auto; /* 对话框中心化 */
}

.dialog-footer {
  display: flex;
  justify-content: flex-end; /* 对齐到右边 */
  padding: 10px;
}

.el-button {
  margin-left: 15px;
}

.el-table {
  background-color: #fff;
  border-radius: 4px;
  box-shadow: 0 2px 12px rgba(0, 0, 0, 0.1);
}

@media (max-width: 768px) {
  .el-dialog {
    width: 95%; /* 更适合小屏幕的宽度 */
  }
}
</style>
