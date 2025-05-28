<template>
  <div>
    <h1 style="text-align: center; margin-bottom: 30px">考试成绩信息</h1>
    <el-container>
      <el-row gutter="20">
        <el-col v-for="(result, index) in examResults" :key="index" :span="8">
          <el-card class="card">
            <h3 style="margin: 0; color: #409eff">
              课程: {{ result.courseName }}
            </h3>
            <p>
              分数:
              <span :style="{ color: getScoreColor(result.score) }">{{
                result.score
              }}</span>
            </p>
            <p>学年学期: {{ result.year }} {{ result.term }}</p>
            <p>备注: {{ result.remark }}</p>
            <p>教师: {{ result.tname }}</p>
          </el-card>
        </el-col>
      </el-row>
    </el-container>
  </div>
</template>

<script>
import { ref, onMounted } from 'vue'
import gradeApi from '@/api/stugrade'
import Cookies from 'js-cookie'

export default {
  name: 'ScoreDisplay',
  setup() {
    const examResults = ref([])

    onMounted(async () => {
      const sid = parseInt(Cookies.get('sid'), 10)
      if (sid) {
        const response = await gradeApi(sid, 'student')
        examResults.value = response.data
      }
    })

    function getScoreColor(score) {
      if (score >= 90) return 'green'
      if (score >= 75) return 'orange'
      if (score >= 60) return 'red'
      return 'gray'
    }

    return { examResults, getScoreColor }
  },
}
</script>

<style>
.card {
  border: 1px solid #dcdfe6; /* 边框 */
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* 阴影 */
  padding: 20px; /* 内部填充 */
  border-radius: 10px; /* 圆角效果 */
  transition: all 0.3s; /* 过渡效果 */
}

.card:hover {
  transform: translateY(-3px); /* 鼠标悬停效果 */
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2); /* 更明显的阴影 */
}
</style>
