<template>
  <div class="relative flex w-full h-full items-center justify-center">
    <div class="flex bg-white flex-col px-5 rounded-xl border-solid border-2 border-black">
      <div class="text-center text-xl py-5">AcFun Comment Observer</div>
      <el-form ref="ruleFormRef" :model="queryParam" style="max-width: 300px" :rules="rules" status-icon>
        <el-form-item prop="aid">
          <el-input v-model.number="queryParam.aid" placeholder="文章AC号" />
        </el-form-item>
        <el-form-item prop="floorNumber">
          <el-input v-model.number="queryParam.floorNumber" placeholder="楼层" />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" style="width: 300px;" @click="onSubmit(ruleFormRef)">观察</el-button>
        </el-form-item>
      </el-form>
    </div>
    <div class="absolute inset-x-0 bottom-0">
      <div>例如: 输入Article ID = 43802951, Floor Number = 6</div>
      <div>
        表示查询文章
        <a href="https://www.acfun.cn/a/ac43802951" style="text-decoration:underline;">
          ac43802951
        </a>
        下以盖楼模式展示评论的第6楼已被删除的评论内容。
      </div>
      <div>本Demo只保存文章区中综合区部分文章下的评论，不涉及任何用户隐私。</div>
    </div>
  </div>
</template>

<script lang="ts" setup>
import { reactive, ref } from 'vue'
import { FormInstance, FormRules, ElMessageBox } from 'element-plus'
import { queryCommentApi } from '@/api/comment'

const ruleFormRef = ref<FormInstance>()

const queryParam = reactive({
  aid: '',
  floorNumber: '',
})

const check = (_rule: any, value: any, callback: any) => {
  if (!value || value === '') {
    return callback(new Error('不能为空'))
  }
  if (!/^(\d+)$/.test(value)) {
    return callback(new Error('请输入数字值'))
  }
  callback()
}

const rules = reactive<FormRules<typeof queryParam>>({
  aid: [{ validator: check, trigger: 'blur' }],
  floorNumber: [{ validator: check, trigger: 'blur' }],
})

const onSubmit = (form: FormInstance | undefined) => {
  if (!form) return
  form.validate((valid) => {
    if (!valid) {
      return false
    }

    queryCommentApi(queryParam.aid, queryParam.floorNumber)
      .then((response: any) => {
        console.log(typeof (response))
        ElMessageBox.alert(JSON.stringify(response), '结果')
      })
      .catch((error: any) => {
        console.log(error)
      })
    return true
  })
}

</script>

<style lang="scss" scoped></style>
