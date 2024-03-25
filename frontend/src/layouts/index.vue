<template>
  <div v-show="true" class="h-screen w-screen flex flex-col">
    <navibar id="navibar" class=" bg-cyan-500" />
    <div :style="{ height: appMainHeight + 'px' }" class="flex flex-row flex-grow">
      <sidebar id="sidebar" />
      <div class="w-full bg-slate-200 p-2 m-2 overflow-y-auto">
        <router-view />
      </div>
    </div>
  </div>
</template>

<script lang="ts" setup>
import navibar from './components/navibar.vue'
import sidebar from './components/sidebar.vue'
import { ref, onMounted, onUpdated } from 'vue'

const appMainHeight = ref(0)

// 窗口尺寸变化
onMounted(() => {
  console.log('onMounted')
  window.onresize = function wondowResize() {
    console.log('size changed')
    calcAppMainSize()
  }
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
}

</script>

<style lang="scss" scoped></style>
