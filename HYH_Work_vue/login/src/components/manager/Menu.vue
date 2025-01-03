<template>
  <el-container>
    <el-header>
      <el-row>
        <el-col :span="4" class="flex-center-end">
          <el-avatar :size="40" :src="circleUrl" />
          <span class="username-text">{{ uname }}</span>
          <el-button class="logout-button" @click="logout">退出登录</el-button>
        </el-col>
      </el-row>
    </el-header>
    <el-container>
      <el-aside width="auto">
        <el-button class="toggleCollapse" @click="toggleCollapse">
          <el-icon><Fold /></el-icon>
        </el-button>
        <el-menu
          :default-active="defaultActiveRoute"
          class="Menu"
          :collapse="isCollapse"
          router
          @open="handleOpen"
          @close="handleClose"
        >
          <el-menu-item index="/manager-dashboard/major-management">
            <el-icon><User /></el-icon>
            <template #title>专业管理</template>
          </el-menu-item>
          <el-menu-item index="/manager-dashboard/class-management">
            <el-icon><View /></el-icon>
            <template #title>班级管理</template>
          </el-menu-item>
          <el-menu-item index="/manager-dashboard/classroom-management">
            <el-icon><Grid /></el-icon>
            <template #title>课室管理</template>
          </el-menu-item>
          <el-menu-item index="/manager-dashboard/student-management">
            <el-icon><EditPen /></el-icon>
            <template #title>学生管理</template>
          </el-menu-item>
          <el-menu-item index="/manager-dashboard/teacher-management">
            <el-icon><EditPen /></el-icon>
            <template #title>教师管理</template>
          </el-menu-item>
        </el-menu>
      </el-aside>
      <el-main>
        <RouterView />
      </el-main>
    </el-container>
  </el-container>
</template>

<script lang="ts" setup>
import router from '@/router'
import { Fold, User, EditPen, Grid, View } from '@element-plus/icons-vue'
import { ElMessage } from 'element-plus'
import Cookies from 'js-cookie'
import { ref, reactive, toRefs, watch } from 'vue'
import { useRoute } from 'vue-router'

const state = reactive({
  circleUrl:
    'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png',
})

const { circleUrl } = toRefs(state)
const route = useRoute()
const isCollapse = ref(true)
const defaultActiveRoute = ref(route.path)
const uname = Cookies.get('name')

watch(
  () => route.path,
  (newPath) => {
    defaultActiveRoute.value = newPath
  },
)

const handleOpen = (key: string, keyPath: string[]) => {
  console.log('Opened:', key, keyPath)
}
const handleClose = (key: string, keyPath: string[]) => {
  console.log('Closed:', key, keyPath)
}
const toggleCollapse = () => {
  isCollapse.value = !isCollapse.value
}
const logout = () => {
  console.log('Logging out...')
  Cookies.remove('name')
  Cookies.remove('role')
  router.push('/').catch((err) => {
    console.error('Router Push Error:', err)
    ElMessage.error('导航到指定页面失败，请联系管理员')
  })
}
</script>

<style scoped>
.Menu:not(.el-menu--collapse) {
  width: 200px;
  border-right: 1px solid #e4e7ed; /* 为菜单添加右边框 */
}
.toggleCollapse {
  width: 64px;
  height: 64px;
}
.flex-center-end {
  display: flex;
  align-items: center;
  justify-content: flex-end;
}
.username-text {
  margin-right: 10px;
  font-weight: 600; /* 加粗文字 */
  color: #333; /* 改变字体颜色 */
}
.logout-button {
  margin-left: 14px;
  background-color: #f56c6c; /* 设置按钮背景色 */
  color: white; /* 文字颜色 */
  border: none; /* 去掉边框 */
}
.logout-button:hover {
  background-color: #e10505; /* 悬停时改变按钮颜色 */
  transition: background-color 0.3s ease; /* 动效 */
}
.el-header {
  background-color: #f9f9f9; /* 设置头部背景色 */
  border-bottom: 1px solid #e4e7ed; /* 设置底部边框 */
}
.el-container {
  background-color: #ffffff; /* 主容器背景色 */
}
</style>
