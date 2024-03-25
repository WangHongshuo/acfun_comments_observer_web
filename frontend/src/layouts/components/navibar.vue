<template>
  <div class="navibar min-h-12 flex items-center justify-between px-4">
    <div class="flex flex-row items-center gap-x-3">
      <hambuger :is-collapse="isCollapse" @click="toggleSidbar" />
      <div>logo</div>
    </div>
    <div class=" text-center text-xl">正在装修中...</div>
    <div class="toolbar">
      <el-button @click="onLogin">登录</el-button>
    </div>
  </div>
</template>

<script lang="ts" setup>
import hambuger from '@/components/hamburger/index.vue'
import { toRef, onMounted } from 'vue'
import useAppStore from '@/store/app'
import { useRouter } from "vue-router"

const router = useRouter()

const appStore = useAppStore()
const isCollapse = toRef(appStore.sidebar, 'isCollapse')

onMounted(() => {
  console.log('navibar', isCollapse)
})

const toggleSidbar = () => {
  appStore.toggleSidebar()
}

const onLogin = () => {
  router.push('/login')
}
</script>

<style lang="scss" scoped></style>
