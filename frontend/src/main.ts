import { createApp } from 'vue'
import App from './App.vue'
const app = createApp(App)

// tailwindcss
import './styles/input.css'
import "./styles/output.css"

// pinia
import { createPinia } from 'pinia'
const pinia = createPinia()
app.use(pinia)

// Element Plus
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
  app.component(key, component)
}
app.use(ElementPlus)

// router
import router from '@/router'
app.use(router)

// component
import myComponent from '@/components/index'
Object.keys(myComponent).forEach((key) => {
  app.component(key, myComponent[key])
})

app.mount('#app')
