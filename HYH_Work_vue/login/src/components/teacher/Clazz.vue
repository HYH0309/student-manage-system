<template>
  <div>
    <loading-spinner v-if="isLoading" />
    <!-- 自定义加载指示器 -->

    <table v-if="examResults && examResults.length > 0">
      <thead>
        <tr>
          <th>班级ID</th>
          <th>班级名称</th>
          <th>管理ID</th>
          <th>备注</th>
          <th>学生数量</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="clazz in examResults" :key="clazz.cid">
          <td>{{ clazz.cid }}</td>
          <td>{{ clazz.cname }}</td>
          <td>{{ clazz.mid }}</td>
          <td>{{ clazz.cremark }}</td>
          <td>{{ clazz.studentCount }}</td>
        </tr>
      </tbody>
    </table>

    <div v-else-if="!isLoading && !hasData">没有数据</div>
    <div v-if="error">{{ error }}</div>
  </div>
</template>

<script>
import { ref, onMounted, computed } from 'vue'
import Cookies from 'js-cookie'
import clazzApi from '@/api/clazz'

export default {
  name: 'ClassList',
  props: {
    classes: {
      type: Array,
      default: () => [],
    },
  },
  setup(props) {
    const examResults = ref(props.classes)
    const isLoading = ref(false)
    const error = ref(null)

    const hasData = computed(
      () => examResults.value && examResults.value.length > 0,
    )

    const loadData = async () => {
      isLoading.value = true
      try {
        const tid = parseInt(Cookies.get('tid'), 10)
        if (!isNaN(tid)) {
          const response = await clazzApi.clazzApi(tid, 'teacher')
          examResults.value = response.data || [] // 确保是数组
        } else {
          error.value = '教师ID不可用'
        }
      } catch (err) {
        error.value = `加载数据失败: ${err.message}`
      } finally {
        isLoading.value = false
      }
    }

    onMounted(() => {
      if (!hasData.value) {
        loadData()
      }
    })

    return {
      examResults,
      isLoading,
      error,
      hasData,
    }
  },
}
</script>

<style scoped>
table {
  width: 100%;
  border-collapse: collapse;
}
th,
td {
  border: 1px solid #ccc;
  padding: 10px;
  text-align: left;
}
thead {
  background-color: #efefef;
}
/* 自定义加载指示器样式 */
.loading-spinner {
  text-align: center;
  padding: 20px;
}
</style>
