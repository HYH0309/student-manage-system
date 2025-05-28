<template>
  <div>
    <h2>课程成绩</h2>
    <el-table :data="courses" style="width: 100%">
      <el-table-column
        prop="course.oid"
        label="课程 ID"
        width="180"
      ></el-table-column>
      <el-table-column
        prop="course.courseName"
        label="课程名称"
        width="180"
      ></el-table-column>
      <el-table-column label="成绩">
        <template #default="{ row }">
          <el-tag v-for="(grade, index) in row.grades" :key="index">
            <el-input
              v-model="grade.score"
              style="width: 80px; display: inline-block"
              @blur="updateGrade(row.course.oid, grade.sid, grade.score)"
            ></el-input>
            (学号: {{ grade.sid }}, 姓名: {{ grade.sname }})
          </el-tag>
          <span v-if="row.grades.length === 0">(无成绩)</span>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { ElMessage } from 'element-plus'
import getresouceApi from '@/api/resouce'
import updatesouceApi from '@/api/resouce'
import Cookies from 'js-cookie'

// 定义响应式数据：课程数据
const courses = ref([])

// 更新成绩
const updateGrade = async (oid, sid, score) => {
  try {
    if (score !== '') {
      const newscore = parseFloat(score)
      await updatesouceApi.updatesouceApi(sid, oid, newscore) // 确保此函数存在
      ElMessage.success('成绩更新成功！')
    }
  } catch (error) {
    console.error('Error:', error)
    ElMessage.error(error.message || '更新成绩失败！')
  }
}

// 从 API 获取课程信息
const fetchCourses = async () => {
  // 此函数应获取跟课程相关的信息
  // 这里需要您根据实际情况填充获取课程的 API 调用
  try {
    const tid = Cookies.get('tid')
    const response = await getresouceApi.getresouceApi(tid) // 假设有一个API获取课程数据
    courses.value = response.data || []
  } catch (error) {
    console.error('Error fetching courses:', error)
    ElMessage.error('获取课程信息失败！')
  }
}

// 在组件挂载时获取课程和成绩
onMounted(fetchCourses)
</script>

<style scoped>
.el-table {
  margin-bottom: 20px;
}
</style>
