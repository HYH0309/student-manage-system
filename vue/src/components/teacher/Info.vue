<template>
  <el-card class="user-info-card" shadow="hover">
    <template #header>
      <div class="card-header">
        <span>个人信息</span>
        <div>
          <el-button type="text" @click="toggleEditMode">
            {{ editAddress || editPhone ? '保存' : '编辑' }}
          </el-button>
          <el-button type="primary" @click="openChangePasswordDialog"
            >修改密码</el-button
          >
        </div>
      </div>
    </template>

    <el-form :model="form" label-width="120px">
      <el-form-item label="姓名">
        <el-input v-model="form.name" disabled></el-input>
      </el-form-item>
      <el-form-item label="工号">
        <el-input v-model="form.tid" disabled></el-input>
      </el-form-item>
      <el-form-item label="地址">
        <el-input v-model="form.address" :disabled="!editAddress"></el-input>
      </el-form-item>
      <el-form-item label="联系电话">
        <el-input v-model="form.phone" :disabled="!editPhone"></el-input>
      </el-form-item>
      <el-form-item label="所教课程">
        <el-input v-model="form.course" disabled></el-input>
      </el-form-item>
    </el-form>

    <el-dialog v-model="changePasswordDialog" title="修改密码">
      <el-form :model="passwordForm" label-width="120px">
        <el-form-item label="新密码" required>
          <el-input
            v-model="passwordForm.newPassword"
            type="password"
            placeholder="请输入新密码"
          ></el-input>
        </el-form-item>
        <el-form-item label="确认密码" required>
          <el-input
            v-model="passwordForm.confirmPassword"
            type="password"
            placeholder="请确认新密码"
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
      tid: '',
      name: '',
      address: '',
      phone: '',
      course: '',
    })

    const passwordForm = ref({
      newPassword: '',
      confirmPassword: '',
    })

    const editAddress = ref(false)
    const editPhone = ref(false)
    const changePasswordDialog = ref(false)

    const fetchUserInfo = async () => {
      try {
        const role = 'teacher'
        const uname = Cookies.get('name')
        const response = await infoAPI.infoApi({ uname }, role)

        if (response.data) {
          form.value = {
            name: uname,
            tid: response.data.tid,
            address: response.data.address,
            phone: response.data.phone,
            course: response.data.coursename,
          }
          Cookies.set('tid', response.data.tid)
        } else {
          console.error('无数据')
        }
      } catch (error) {
        console.error('出bug了:', error)
      }
    }

    const toggleEditMode = async () => {
      if (!editAddress.value && !editPhone.value) {
        // 开启编辑模式
        editAddress.value = true
        editPhone.value = true
      } else {
        const tid = parseInt(Cookies.get('tid'), 10)
        // 保存修改后的地址和电话信息
        const res = await infoAPI.editinfoApi(
          form.value.address,
          form.value.phone,
          'teacher',
          tid,
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

    const openChangePasswordDialog = () => {
      changePasswordDialog.value = true
    }

    const submitChangePassword = async () => {
      // 确保新密码和确认密码相同
      if (
        passwordForm.value.newPassword !== passwordForm.value.confirmPassword
      ) {
        ElMessage.error('两次输入的密码不一致，请重新输入！')
        return
      }
      const tid = Cookies.get('tid')
      // 调用API进行密码修改
      const res = await infoAPI.changePasswordApi(
        passwordForm.value.newPassword,
        'teacher',
        tid,
      )
      if (res.code) {
        ElMessage.success(res.msg)
      } else {
        ElMessage.error(res.msg)
      }

      changePasswordDialog.value = false // 关闭对话框
      passwordForm.value.newPassword = '' // 清空输入框
      passwordForm.value.confirmPassword = ''
    }

    onMounted(fetchUserInfo)

    return {
      form,
      editAddress,
      editPhone,
      changePasswordDialog,
      passwordForm,
      fetchUserInfo,
      toggleEditMode,
      openChangePasswordDialog,
      submitChangePassword,
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
</style>
