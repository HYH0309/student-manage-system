<template>
  <el-card class="user-info-card" shadow="hover">
    <template #header>
      <div class="card-header">
        <span class="card-title">个人信息</span>
        <el-row type="flex" justify="end" align="middle">
          <el-button type="text" @click="toggleEditMode">
            {{ editAddress || editPhone ? '保存' : '编辑' }}
          </el-button>
          <el-button type="primary" @click="openChangePasswordDialog"
            >修改密码</el-button
          >
        </el-row>
      </div>
    </template>

    <el-form :model="form" label-width="120px" class="user-info-form">
      <el-form-item label="姓名">
        <el-input v-model="form.name" disabled></el-input>
      </el-form-item>
      <el-form-item label="学号">
        <el-input v-model="form.sid" disabled></el-input>
      </el-form-item>
      <el-form-item label="地址">
        <el-input v-model="form.address" :disabled="!editAddress"></el-input>
      </el-form-item>
      <el-form-item label="联系电话">
        <el-input v-model="form.phone" :disabled="!editPhone"></el-input>
      </el-form-item>
      <el-form-item label="专业">
        <el-input v-model="form.major" disabled></el-input>
      </el-form-item>
      <el-form-item label="班级">
        <el-input v-model="form.class" disabled></el-input>
      </el-form-item>
    </el-form>

    <el-dialog v-model="changePasswordDialog" title="修改密码">
      <el-form :model="passwordForm" label-width="120px">
        <el-form-item label="新密码" required>
          <el-input
            v-model="passwordForm.newPassword"
            type="password"
          ></el-input>
        </el-form-item>
        <el-form-item label="确认密码" required>
          <el-input
            v-model="passwordForm.confirmPassword"
            type="password"
          ></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <el-button @click="changePasswordDialog = false">取消</el-button>
        <el-button type="primary" @click="submitChangePassword">确认</el-button>
      </template>
    </el-dialog>
  </el-card>
</template>

<script>
import { ref, onMounted } from 'vue'
import Cookies from 'js-cookie'
import infoAPI from '@/api/info'
import { ElMessage } from 'element-plus'

export default {
  name: 'Info',
  setup() {
    const form = ref({
      sid: '',
      name: '',
      address: '',
      phone: '',
      major: '',
      class: '',
    })

    const editAddress = ref(false)
    const editPhone = ref(false)
    const changePasswordDialog = ref(false) // 确保这里是正确的状态初始

    const passwordForm = ref({
      newPassword: '',
      confirmPassword: '',
    })

    const fetchUserInfo = async () => {
      try {
        const role = 'student'
        const uname = Cookies.get('name')
        const response = await infoAPI.infoApi({ uname }, role)
        if (response.data) {
          form.value = {
            name: uname,
            sid: response.data.sid,
            address: response.data.address,
            phone: response.data.phone,
            major: response.data.mname,
            class: response.data.cname,
          }
          Cookies.set('cname', response.data.cname)
          Cookies.set('sid', response.data.sid)
        } else {
          console.error('无数据')
        }
      } catch (error) {
        console.error('出bug了:', error)
        ElMessage.error('获取用户信息失败')
      }
    }

    const toggleEditMode = async () => {
      if (!editAddress.value && !editPhone.value) {
        editAddress.value = true
        editPhone.value = true
      } else {
        const sid = Cookies.get('sid')
        const res = await infoAPI.editinfoApi(
          form.value.address,
          form.value.phone,
          'student',
          sid,
        )
        if (res.code) {
          ElMessage.success(res.msg)
        } else {
          ElMessage.error(res.msg)
        }
        editAddress.value = false
        editPhone.value = false
      }
    }

    const openChangePasswordDialog = () => {
      changePasswordDialog.value = true // 打开对话框
      passwordForm.value = { newPassword: '', confirmPassword: '' } // 重置密码输入
    }

    const submitChangePassword = async () => {
      if (
        passwordForm.value.newPassword !== passwordForm.value.confirmPassword
      ) {
        ElMessage.error('密码不匹配，请确认输入。')
        return
      }

      try {
        const sid = Cookies.get('sid')
        const response = await infoAPI.changePasswordApi(
          passwordForm.value.newPassword,
          'student',
          sid,
        )
        if (response.code) {
          ElMessage.success('密码修改成功')
          changePasswordDialog.value = false // 关闭对话框
        } else {
          ElMessage.error(response.msg)
        }
      } catch (error) {
        ElMessage.error('修改密码失败，请重试。')
        ElMessage.error(response.msg)
        console.error('修改密码错误:', error)
      }
    }

    onMounted(fetchUserInfo)

    return {
      form,
      editAddress,
      editPhone,
      changePasswordDialog,
      openChangePasswordDialog,
      passwordForm,
      submitChangePassword,
      fetchUserInfo,
      toggleEditMode,
    }
  },
}
</script>

<style scoped>
.user-info-card {
  width: 600px;
  margin: 20px auto;
}

.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.card-title {
  font-weight: bold;
  font-size: 1.2em;
  color: #333;
}

.user-info-form {
  padding: 10px;
}

.el-dialog {
  width: 400px; /* 控制修改密码对话框的宽度 */
}

.el-button {
  margin-top: 10px; /* 按钮的间距 */
}
</style>
