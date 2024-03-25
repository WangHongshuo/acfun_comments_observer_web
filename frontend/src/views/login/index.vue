<template>
  <div class="relative flex w-full h-full items-center justify-center">
    <div class="flex bg-white flex-col px-5 rounded-xl border-solid border-2 border-black">
      <div class="text-center text-xl py-5">登 录</div>
      <el-form ref="ruleFormRef" :model="loginParam" style="max-width: 300px" status-icon>
        <el-form-item prop="email">
          <el-input v-model="loginParam.email" placeholder="邮箱" />
        </el-form-item>
        <el-form-item prop="password">
          <el-input v-model="loginParam.password" type="password" placeholder="密码" show-password />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" style="width: 120px;" @click="onLogin">登录</el-button>
          <el-button type="default" style="width: 120px;" disabled>注册</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script lang="ts" setup>
import { reactive } from 'vue'

const loginParam = reactive({
  email: '',
  password: '',
})

const onLogin = () => {
  console.log(loginParam)
}

</script>
