import { createApp } from 'vue'
import App from './App.vue'
const app = createApp(App)

import './styles/input.css'
import "./styles/output.css"

// pinia
import { createPinia } from 'pinia'
import useStore from '@/store'
const pinia = createPinia()
app.use(pinia)
app.config.globalProperties.$store = useStore()

// Element Plus
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
  app.component(key, component)
}
app.use(ElementPlus)


import router from '@/router'
app.use(router)

import myComponent from '@/components/index'
Object.keys(myComponent).forEach((key) => {
  app.component(key, myComponent[key])
})

app.mount('#app')
