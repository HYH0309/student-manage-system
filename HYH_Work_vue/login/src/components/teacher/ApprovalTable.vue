<template>
  <div>
    <el-card>
      <el-table :data="approvals" style="width: 100%">
        <el-table-column prop="sid" label="ID" width="100"></el-table-column>
        <el-table-column prop="type" label="类型" width="180"></el-table-column>
        <el-table-column prop="reason" label="理由"></el-table-column>
        <el-table-column
          prop="sname"
          label="姓名"
          width="100"
        ></el-table-column>
      </el-table>
    </el-card>
  </div>
</template>

<script>
import { ref, onMounted } from 'vue'
import approvalApi from '@/api/show' // 导入您的 API

export default {
  name: 'ApprovalTable',
  setup() {
    const approvals = ref([]) // 使用 ref 创建响应式数据

    const fetchApprovals = async () => {
      try {
        const response = await approvalApi.approvalApi() // 替换为您的实际 API URL
        approvals.value = response.data // 将获取的数据赋给 approvals
      } catch (error) {
        console.error('获取审批数据失败:', error)
      }
    }

    // 组件挂载后获取数据
    onMounted(() => {
      fetchApprovals()
    })

    return {
      approvals,
    }
  },
}
</script>

<style scoped>
/* 这里可以添加一些本地的样式 */
.el-card {
  margin: 20px;
  padding: 15px;
}
</style>
