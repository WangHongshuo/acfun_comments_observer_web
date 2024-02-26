<template>
  <div v-show="true" class="h-screen w-screen flex flex-col flex-grow">
    <navibar />
    <div :style="{ height: appMainHeight + 'px' }" class="w-full bg-gray-200 py-4 overflow-y-auto">
      <router-view />
    </div>
  </div>
</template>

<script lang="ts" setup>
import navibar from './components/navibar.vue'
import { ref, onMounted, onUpdated } from 'vue'

let appMainHeight = ref(0)

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
  console.log(navibarHeight)
  appMainHeight.value = window.innerHeight - navibarHeight
  console.log(appMainHeight.value)
}

</script>

<style lang="scss" scoped></style>
