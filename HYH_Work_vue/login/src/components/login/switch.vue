<template>
  <div id="switch-cnt" class="switch">
    <div class="switch__circle"></div>
    <div class="switch__circle switch__circle--t"></div>
    <!-- 状态1 -->
    <div id="switch-c1" class="switch__container">
      <h2 class="switch__title title">你要登录吗</h2>
      <p class="switch__description description">
        这是禾奕的网站，202325710209，请输入密码登录。
      </p>
      <button class="switch__button button switch-btn" @click="change">
        登录
      </button>
    </div>
    <!-- 状态2 -->
    <div id="switch-c2" class="switch__container is-hidden">
      <h2 class="switch__title title">新朋友？</h2>
      <p class="switch__description description">
        ？什么你也想成为我数据库里的账号吗？那就输入信息吧
      </p>
      <button class="switch__button button switch-btn" @click="change">
        注册
      </button>
    </div>
  </div>
</template>

<script setup lang="ts">
import { useMainStore } from '@/stores/message'
const mainStore = useMainStore()

const change = () => {
  // 加上as any防止ts类型检查报错
  const switchC1 = document.querySelector('#switch-c1') as any
  const switchC2 = document.querySelector('#switch-c2') as any
  const switchCircle = document.querySelectorAll('.switch__circle') as any
  const switchCtn = document.querySelector('#switch-cnt') as any

  switchCtn.classList.add('is-gx')
  setTimeout(function () {
    switchCtn.classList.remove('is-gx')
  }, 1500)
  switchCtn.classList.toggle('is-txr')
  switchCircle[0].classList.toggle('is-txr')
  switchCircle[1].classList.toggle('is-txr')

  switchC1.classList.toggle('is-hidden')
  switchC2.classList.toggle('is-hidden')

  mainStore.showSignup = !mainStore.showSignup
}
</script>

<style scoped>
@import '../../styles/login.scss';
/*
  将源码中的css样式单独存放,在各组件中导入就可以。
  后续整理代码时建议，将全局样式和局部样式分开。
  */
</style>
