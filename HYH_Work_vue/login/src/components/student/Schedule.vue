<template>
  <div class="container">
    <h1 class="title">课表查询</h1>
    <div class="flex flex-wrap gap-2 items-center">
      <el-select v-model="academicYear" placeholder="选择学年" class="select">
        <el-option
          v-for="item in academicYearOptions"
          :key="item"
          :label="item"
          :value="item"
        />
      </el-select>

      <el-select v-model="semester" placeholder="选择学期" class="select">
        <el-option
          v-for="item in semesterOptions"
          :key="item"
          :label="item"
          :value="item"
        />
      </el-select>

      <el-select v-model="weekno" placeholder="选择周" class="select">
        <el-option
          v-for="item in weeknoOptions"
          :key="item"
          :label="item"
          :value="item"
        />
      </el-select>

      <el-button type="primary" class="search-button" @click="fetchschedule">
        查询
        <el-icon class="el-icon--right">
          <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1024 1024">
            <path
              fill="currentColor"
              d="m795.904 750.72 124.992 124.928a32 32 0 0 1-45.248 45.248L750.656 795.904a416 416 0 1 1 45.248-45.248zM480 832a352 352 0 1 0 0-704 352 352 0 0 0 0 704"
            />
          </svg>
        </el-icon>
      </el-button>
    </div>
    <div id="coursesTable" class="table-container"></div>
  </div>
</template>

<script>
import schedule from '@/api/schedule'
import Timetables from 'timetables'
import { ref, onMounted } from 'vue'
import Cookies from 'js-cookie'

export default {
  setup() {
    const academicYearOptions = [
      '2021-2022学年',
      '2022-2023学年',
      '2023-2024学年',
    ]
    const semesterOptions = ['第一学期', '第二学期']
    const weeknoOptions = Array.from({ length: 16 }, (_, index) => index + 1)

    const academicYear = ref(null)
    const semester = ref(null)
    const weekno = ref(null)

    const timetables = Array.from({ length: 5 }, () => Array(10).fill(''))
    const timetableType = [
      [{ index: '1', name: '08:00' }, 1],
      [{ index: '2', name: '09:00' }, 1],
      [{ index: '3', name: '10:00' }, 1],
      [{ index: '4', name: '11:00' }, 1],
      [{ index: '5', name: '12:00' }, 1],
      [{ index: '6', name: '13:00' }, 1],
      [{ index: '7', name: '14:00' }, 1],
      [{ index: '8', name: '15:00' }, 1],
      [{ index: '9', name: '16:00' }, 1],
      [{ index: '10', name: '17:00' }, 1],
    ]
    const week = ['周一', '周二', '周三', '周四', '周五']
    const styles = {
      Gheight: 60, // 减少单元格高度
      leftHandWidth: 60, // 调整左侧宽度
      palette: ['#ff6633', '#eeeeee'],
    }

    const fetchschedule = async () => {
      if (!academicYear.value || !semester.value || !weekno.value) {
        console.error('请选择正确的学年、学期和周数')
        return
      }

      try {
        const cname = Cookies.get('cname')
        const response = await schedule.scheduleApi(
          academicYear.value,
          semester.value,
          cname,
          weekno.value,
          'student',
        )

        if (response.code) {
          const timetableData = response.table
          timetableData.forEach((row, i) => {
            row.forEach((courseInfo, j) => {
              timetables[i][j] = courseInfo || ''
            })
          })
          onchange()
        } else {
          console.error('无数据')
        }
      } catch (error) {
        console.error('出bug了:', error)
      }
    }

    const timetable = ref(null)

    const initTimetable = () => {
      timetable.value = new Timetables({
        el: '#coursesTable',
        timetables: timetables,
        week: week,
        timetableType: timetableType,
        gridOnClick: function (e) {
          alert(
            e.name +
              '  ' +
              e.week +
              ', 第' +
              e.index +
              '节课, 课长' +
              e.length +
              '节',
          )
        },
        styles: styles,
      })
    }

    function onchange() {
      timetable.value.setOption({
        timetables: timetables,
        week: week,
        timetableType: timetableType,
        gridOnClick: function (e) {
          alert(
            e.name +
              '  ' +
              e.week +
              ', 第' +
              e.index +
              '节课, 课长' +
              e.length +
              '节',
          )
        },
        styles: styles,
      })
    }

    onMounted(() => {
      initTimetable()
    })

    return {
      onchange,
      fetchschedule,
      academicYearOptions,
      semesterOptions,
      weeknoOptions,
      academicYear,
      semester,
      weekno,
    }
  },
}
</script>

<style scoped>
.title {
  text-align: center;
  margin-bottom: 20px;
  font-size: 22px; /* 调整标题的大小 */
  color: #333;
}

.select {
  width: 150px; /* 减少select的宽度 */
  min-width: 100px; /* 设置最小宽度 */
}

.search-button {
  padding: 0 15px; /* 减少按钮的内边距 */
  font-size: 14px; /* 减少按钮的字体大小 */
}

.table-container {
  margin-top: 30px;
  overflow: auto; /* 启用滚动条，避免溢出 */
}

/* 使得容器具有一定的padding，同时上移内容 */
.container {
  padding: 20px;
  margin-top: -20px; /* 使用负边距向上移动整体内容 */
}
</style>
