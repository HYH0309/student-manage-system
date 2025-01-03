<!-- eslint-disable vue/no-unused-refs -->
<template>
  <div id="b-container" class="container b-container">
    <form id="b-form" class="form" method="" action="" @submit.prevent="login">
      <h2 class="form_title title">这里是登录我的网站哦！！！</h2>
      <el-form ref="loginFormRef" :model="loginForm" :rules="rules">
        <el-form-item prop="username">
          <el-input
            v-model="loginForm.username"
            class="form__input"
            type="text"
            placeholder="Name"
          />
        </el-form-item>
        <el-form-item prop="password">
          <el-input
            v-model.lazy="loginForm.password"
            class="form__input"
            type="password"
            placeholder="Password"
          />
        </el-form-item>
        <el-form-item prop="captcha">
          <div class="captcha-wrapper">
            <el-input
              v-model="loginForm.captcha"
              class="form__input"
              type="text"
              placeholder="Captcha"
            />
          </div>
        </el-form-item>
        <el-form-item label="" prop="role">
          <el-radio-group v-model="loginForm.role">
            <el-radio label="student">Student</el-radio>
            <el-radio label="teacher">Teacher</el-radio>
            <el-radio label="manager">Manager</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <img
        :src="captchaUrl"
        alt="Captcha"
        class="captcha-img"
        @click="refreshCaptcha"
      />
      <br />
      <div class="form__button">
        <el-button type="primary" @click="login">SIGN IN</el-button>
      </div>
    </form>
  </div>
</template>

<script setup lang="ts">
import { reactive, ref } from 'vue'
import { useMainStore } from '@/stores/message'
import api from '@/api/login'
import { storeToRefs } from 'pinia'
import { ElMessage } from 'element-plus'
import { type User } from '@/api/login'
import Cookies from 'js-cookie'

const router = useRouter()
const mainStore = useMainStore()
const { showSignup } = storeToRefs(mainStore)
const captchaUrl = ref('http://localhost:3009/api/code') // 默认载入验证码的URL

const refreshCaptcha = () => {
  captchaUrl.value = `http://localhost:3009/api/code?_t=${Date.now()}` // 刷新验证码图片
}

watch(showSignup, () => {
  const bContainer = document.querySelector('#b-container') as HTMLElement
  bContainer.classList.toggle('is-txl')
  bContainer.classList.toggle('is-z200')
})

const loginForm = reactive<User & { role: string }>({
  username: '',
  password: '',
  captcha: '',
  role: 'student', // 默认选中的角色
})

const rules = reactive({
  username: [
    { required: true, message: '请输入你的用户名', trigger: 'blur' },
    { min: 3, max: 15, message: '用户名长度应该在3到15之间', trigger: 'blur' },
  ],
  password: [
    { required: true, message: '请输入你的密码', trigger: 'blur' },
    { min: 0, max: 20, message: '密码长度应该在6到20之间', trigger: 'blur' },
  ],
  captcha: [{ required: true, message: '请输入验证码', trigger: 'blur' }],
})

const login = async () => {
  const res = await api.loginApi(loginForm)
  try {
    if (res.code) {
      ElMessage.success(res.msg)
      Cookies.set('name', loginForm.username, { expires: 7 }) // 存储用户名, 有效期7天
      Cookies.set('role', loginForm.role, { expires: 7 }) // 存储用户角色, 有效期7天

      // 根据角色重定向
      let routeName = ''
      switch (loginForm.role) {
        case 'student':
          routeName = 'StudentDashboard'
          break
        case 'teacher':
          routeName = 'TeacherDashboard'
          break
        case 'manager':
          routeName = 'ManagerDashboard'
          break
      }

      router.push({ name: routeName }).catch((err) => {
        // 处理路由跳转失败的情况
        console.error('Router Push Error:', err)
        ElMessage.error('导航到指定页面失败，请联系管理员')
      })
    } else {
      ElMessage.error(res.msg || '登录失败')
    }
  } catch (error) {
    console.error('Error:', error)
    ElMessage.error('请求失败，请稍后再试')
  }
}
</script>

<style scoped>
@import '../../styles/login.scss';
</style>
