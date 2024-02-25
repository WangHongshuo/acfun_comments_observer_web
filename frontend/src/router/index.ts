import { createWebHashHistory, createRouter } from 'vue-router'

export const constantRoutes = [
  {
    path: '/',
    component: () => import('@/views/search-page/index.vue')
  },
  {
    path: '/test',
    component: () => import('@/views/test/index.vue')
  },
  {
    path: '/login',
    component: () => import('@/views/login/index.vue')
  },
]

const router = createRouter({
  history: createWebHashHistory(),
  routes: constantRoutes,
})

export default router;
