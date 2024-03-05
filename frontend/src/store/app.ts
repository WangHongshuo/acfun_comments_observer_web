import { AppState } from '@/types/store/app'
import { localStorage } from '@/utils/storage'
import { defineStore } from 'pinia'

const APP_SIDEBAR_ISCOLLAPSE = 'app.siderbar.isCollapse'

const useAppStore = defineStore({
  id: 'app',
  state: (): AppState => ({
    name: localStorage.get('name') || 'Small Tools',
    device: 'desktop',
    sidebar: {
      isCollapse: localStorage.get(APP_SIDEBAR_ISCOLLAPSE) ? localStorage.get(APP_SIDEBAR_ISCOLLAPSE) : false,
      withoutAnimation: false,
    },
  }),
  actions: {
    setName(name: string) {
      this.name = name
      localStorage.set('name', name)
    },
    toggleSidebar() {
      this.sidebar.isCollapse = !this.sidebar.isCollapse
      this.sidebar.withoutAnimation = false
      if (this.sidebar.isCollapse) {
        localStorage.set(APP_SIDEBAR_ISCOLLAPSE, true)
      } else {
        localStorage.set(APP_SIDEBAR_ISCOLLAPSE, false)
      }
    },
    closeSideBar(withoutAnimation: any) {
      localStorage.set(APP_SIDEBAR_ISCOLLAPSE, false)
      this.sidebar.isCollapse = false
      this.sidebar.withoutAnimation = withoutAnimation
    },
    toggleDevice(device: string) {
      this.device = device
    },
  },
})

export default useAppStore
