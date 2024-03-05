<template>
  <el-icon :size="30">
    <Expand v-if="props.isCollapse" />
    <Fold v-else />
  </el-icon>
</template>

<script lang="ts" setup>
interface Props {
  isCollapse?: boolean
}

const props = withDefaults(defineProps<Props>(), {
  isCollapse: false
})

</script>

<style lang="scss" scoped></style>
