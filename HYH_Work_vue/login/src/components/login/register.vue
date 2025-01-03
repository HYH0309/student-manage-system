<template>
  <div id="a-container" class="container a-container">
    <form id="a-form" class="form" @submit.prevent="register">
      <h2 class="form_title title">这里可以注册一个新的账号哦</h2>
      <el-form ref="registerFormRef" :model="registerForm" :rules="rules">
        <el-form-item prop="username">
          <el-input
            v-model="registerForm.username"
            class="form__input"
            type="username"
            placeholder="Name"
          />
        </el-form-item>
        <el-form-item prop="password">
          <el-input
            v-model="registerForm.password"
            class="form__input"
            type="password"
            placeholder="Password"
          />
        </el-form-item>
        <el-form-item prop="captcha">
          <div class="captcha-wrapper">
            <el-input
              v-model="registerForm.captcha"
              class="form__input"
              type="text"
              placeholder="Captcha"
            />
          </div>
        </el-form-item>
        <el-form-item label="" prop="role">
          <el-radio-group v-model="registerForm.role">
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
        <el-button type="primary" :disabled="loading" @click="register"
          >SIGN UP</el-button
        >
      </div>
    </form>
  </div>
</template>

<script setup lang="ts">
import { ref, reactive, watch } from 'vue'
import { useMainStore } from '@/stores/message'
import api from '@/api/login'
import { ElForm, ElMessage } from 'element-plus'

const mainStore = useMainStore()

const { showSignup } = storeToRefs(mainStore)
const captchaUrl = ref('http://47.92.90.228:3009/api/code') // 默认载入验证码的URL

const refreshCaptcha = () => {
  captchaUrl.value = `http://47.92.90.228:3009/api/code?_t=${Date.now()}` // 刷新验证码图片
}

watch(showSignup, () => {
  const aContainer = document.querySelector('#a-container') as HTMLElement
  aContainer.classList.toggle('is-txl')
})

const registerForm = reactive({
  username: '',
  password: '',
  captcha: '',
  role: '',
})

const registerFormRef = ref<InstanceType<typeof ElForm> | null>(null)

const rules = reactive({
  username: [
    { required: true, message: '请输入你的用户名', trigger: 'blur' },
    { min: 3, max: 5, message: '长度应该在3到5之间', trigger: 'blur' },
  ],
  password: [
    { required: true, message: '请输入你的密码', trigger: 'blur' },
    { min: 0, max: 5, message: '长度应该在0到5之间', trigger: 'blur' },
  ],
})

const loading = ref(false)

const register = async () => {
  loading.value = true
  try {
    const res = await api.registerApi(registerForm)
    if (res && res.code) {
      ElMessage.success(res.msg) // 显示成功消息
      console.log('Response Code:', res.code)
      // 根据返回的 code 值处理逻辑
    } else {
      console.error('Unexpected response structure', res)
    }
  } catch (error) {
    console.error('Error during registration:', error)
  } finally {
    loading.value = false
  }
}
</script>

<style scoped>
@import '../../styles/login.scss';
</style>
