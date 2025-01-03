<template>
  <router-view :key="key" />
  <Copyright />
</template>

<script setup lang="ts">
import { isMobile, watchResize } from '@bassist/utils'
import { computed } from 'vue'
import { useRoute } from 'vue-router'
import Copyright from './components/Copyright.vue'

const route = useRoute()
const key = computed(() => `${String(route.name || route.path)}-${new Date()}`)

watchResize(() => {
  document.body.className = `platform-${isMobile() ? 'mobile' : 'desktop'}`
})
</script>
