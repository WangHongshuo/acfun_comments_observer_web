<template>
  <div class="navibar bg-blue-300 min-h-12 flex items-center justify-between px-4">
    <div class="flex flex-row items-center gap-x-3">
      <hambuger :is-fold="isFlod" @click="toggleSidbar" />
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
import { ref } from 'vue'
const isFlod = ref(true)

const toggleSidbar = () => {
  isFlod.value = !isFlod.value
}

</script>

<style lang="scss" scoped></style>
