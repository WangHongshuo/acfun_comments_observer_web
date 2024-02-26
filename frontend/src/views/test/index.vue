<template>
  <div class="text-4xl">1</div>
  <div class="text-4xl">1</div>
  <div class="text-4xl">1</div>
  <div class="text-4xl">1</div>
  <div class="text-4xl">1</div>
  <div class="text-4xl">1</div>
  <div class="text-4xl">1</div>
  <div class="text-4xl">1</div>
  <div class="text-4xl">1</div>
  <div class="text-4xl">1</div>
  <div class="text-4xl">1</div>
  <div class="text-4xl">1</div>
  <div class="text-4xl">1</div>
  <div class="text-4xl">1</div>
  <div class="text-4xl">1</div>
  <div class="text-4xl">1</div>
  <div class="text-4xl">1</div>
  <div class="text-4xl">1</div>
  <div class="text-4xl">1</div>
  <div class="text-4xl">1</div>
  <div class="text-4xl">1</div>
  <div class="text-4xl">1</div>
</template>

<script lang="ts" setup>
import { queryCommentApi } from '@/api/comment'

async function test() {
  const ret = await queryCommentApi("444", "444")
  console.log(ret)
}

test()

</script>
