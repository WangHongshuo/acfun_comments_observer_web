<template>
  <el-icon :size="30" @click="toggleClick">
    <Expand v-if="props.isFold" />
    <Fold v-else />
  </el-icon>
</template>

<script lang="ts" setup>
interface Props {
  isFold?: boolean
}

const props = withDefaults(defineProps<Props>(), {
  isFold: false
})

const emits = defineEmits<{
  toggleClick: []
}>()

const toggleClick = () => {
  emits('toggleClick')
}

</script>

<style lang="scss" scoped></style>
