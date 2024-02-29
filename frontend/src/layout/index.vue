<template>
  <div v-show="true" class="h-screen w-screen flex flex-col">
    <navibar id="navibar" />
    <div :style="{ height: appMainHeight + 'px' }" class="flex">
      <sidebar id="sidebar" />
      <div :style="{ width: appMainWidth + 'px' }" class="w-full bg-gray-200 px-2 py-2 overflow-y-auto">
        <router-view />
      </div>
    </div>
  </div>
</template>

<script lang="ts" setup>
import navibar from './components/navibar.vue'
import sidebar from './components/sidebar.vue'
import { ref, onMounted, onUpdated } from 'vue'

let appMainHeight = ref(0)
let appMainWidth = ref(0)

// 窗口尺寸变化
onMounted(() => {
  console.log('onMounted')
  window.onresize = function wondowResize() {
    console.log('size changed')
    calcAppMainSize()
  }
  // TODO：不应该放这里
  calcAppMainSize()
})

// dom更新
onUpdated(() => {
  console.log('onUpdated')
  calcAppMainSize()
})


const calcAppMainSize = () => {
  console.log('calcAppMainSize')
  let navibar = document.getElementById('navibar')
  let navibarHeight = navibar ? navibar.offsetHeight : 0
  appMainHeight.value = window.innerHeight - navibarHeight

  let sidebar = document.getElementById('sidebar')
  let sidebarWidth = sidebar ? sidebar.offsetWidth : 0
  appMainWidth.value = window.innerWidth - sidebarWidth
}

</script>

<style lang="scss" scoped></style>
