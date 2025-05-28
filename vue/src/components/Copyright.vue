<template>
  <el-footer
    style="text-align: center; background-color: #f5f5f5; padding: 10px"
  >
    <small>© {{ currentYear }} {{ authorName }}. 版权所有.</small>
  </el-footer>
</template>

<script>
export default {
  name: 'Copyright',
  data() {
    return {
      currentYear: new Date().getFullYear(), // 获取当前年份
      authorName: '202325710209何逸的个人网站', // 修改为你的名字或公司名
    }
  },
}
</script>

<style scoped>
small {
  color: #666; /* 可根据需要修改颜色 */
}
</style>
