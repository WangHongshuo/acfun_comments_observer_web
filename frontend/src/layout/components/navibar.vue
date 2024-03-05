<template>
  <div class="navibar bg-blue-300 min-h-12 flex items-center justify-between px-4">
    <div class="flex flex-row items-center gap-x-3">
      <hambuger :is-collapse="isCollapse" @click="toggleSidbar" />
      <div>logo</div>
    </div>
    <div class=" text-center text-xl">正在装修中...</div>
    <div class="toolbar">
      <span>登录</span>
    </div>
  </div>
</template>

<script lang="ts" setup>
import hambuger from '@/components/hamburger/index.vue'
import { toRef, onMounted } from 'vue'
import useAppStore from '@/store/app';

const appStore = useAppStore()
const isCollapse = toRef(appStore.sidebar, 'isCollapse')

onMounted(() => {
  console.log('navibar', isCollapse)
})

const toggleSidbar = () => {
  appStore.toggleSidebar()
}

</script>

<style lang="scss" scoped></style>
