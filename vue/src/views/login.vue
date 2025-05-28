<template>
  <div class="body">
    <div class="main">
      <LoginRegister />
      <LoginSign_in />
      <LoginSwitch />
    </div>
  </div>
</template>

<script setup lang="ts">
// 动态设置页面标题
document.title = '登录/注册' // 设置自定义标题
</script>

<style scoped>
*,
*::after,
*::before {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  user-select: none;
}

:root {
  --bg-color: #ecf0f3;
  --text-color: #a0a5a8;
  --shadow-color: #d1d9e6;
}

.body {
  width: 100%;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  font-family: 'Montserrat', sans-serif;
  font-size: 12px;
  background-color: var(--bg-color);
  color: var(--text-color);
}

.main {
  position: relative;
  width: 1000px;
  min-width: 1000px;
  min-height: 600px;
  padding: 25px;
  background-color: var(--bg-color);
  box-shadow:
    10px 10px 10px var(--shadow-color),
    -10px -10px 10px #f9f9f9;
  border-radius: 20px;
  display: flex;
  flex-direction: column;
  gap: 20px;
}

@media (max-width: 1200px) {
  .main {
    transform: scale(0.7);
  }
}

@media (max-width: 1000px) {
  .main {
    transform: scale(0.6);
  }
}

@media (max-width: 800px) {
  .main {
    transform: scale(0.5);
  }
}

@media (max-width: 600px) {
  .main {
    transform: scale(0.4);
  }
}
</style>
