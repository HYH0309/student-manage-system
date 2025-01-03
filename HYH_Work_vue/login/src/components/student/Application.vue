<template>
  <el-form :model="formData" label-width="100px" class="application-form">
    <el-form-item label="申请类型">
      <el-select v-model="formData.type" placeholder="请选择申请类型">
        <el-option label="请假" value="请假"></el-option>
        <el-option label="休学" value="休学"></el-option>
        <el-option label="退学" value="退学"></el-option>
        <el-option label="重置密码" value="重置密码"></el-option>
      </el-select>
    </el-form-item>

    <el-form-item label="学生ID">
      <el-input v-model="formData.sid" disabled></el-input>
    </el-form-item>

    <el-form-item label="申请标题">
      <el-input
        v-model="formData.title"
        placeholder="请输入申请标题"
      ></el-input>
    </el-form-item>

    <el-form-item label="申请理由">
      <el-input
        v-model="formData.reason"
        type="textarea"
        placeholder="请输入申请理由"
      ></el-input>
    </el-form-item>

    <el-form-item>
      <el-button type="primary" class="submit-button" @click="submitForm">
        提交申请
      </el-button>
    </el-form-item>
  </el-form>
</template>

<script lang="ts">
import { ref } from 'vue'
import Cookies from 'js-cookie'
import approvalApi from '@/api/approval'
import { ElMessage } from 'element-plus'

export default {
  name: 'ApplicationForm',
  setup() {
    const sid = parseInt(Cookies.get('sid') || '0', 10)
    const formData = ref({
      sid: sid,
      type: '',
      title: '',
      reason: '',
    })

    const submitForm = async () => {
      if (
        formData.value.type &&
        formData.value.title &&
        formData.value.reason
      ) {
        try {
          const response = await approvalApi.approvalApi(
            formData.value.sid,
            formData.value.type,
            formData.value.title,
            formData.value.reason,
            'student',
          )
          ElMessage.success(response.msg)
        } catch (error) {
          console.error('提交错误:', error)
        }
      } else {
        ElMessage.error('请确保所有字段都已填写。')
      }
    }

    return {
      formData,
      submitForm,
    }
  },
}
</script>

<style scoped>
.application-form {
  max-width: 600px; /* 限制表单最大宽度 */
  margin: 20px auto; /* 中心对齐并增加顶部间距 */
}

.el-form-item {
  margin-bottom: 15px; /* 减少间距 */
}

.submit-button {
  width: 100%; /* 使按钮占满整个宽度，提升可点击性 */
}

.el-input {
  border-radius: 4px; /* 提升输入框的圆角 */
}
</style>
