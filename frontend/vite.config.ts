import { defineConfig, loadEnv } from 'vite'
import vue from '@vitejs/plugin-vue'
import AutoImport from 'unplugin-auto-import/vite'
import * as path from 'path'
import { ElementPlusResolver } from 'unplugin-vue-components/resolvers'
import Components from 'unplugin-vue-components/vite'
import { vitePluginAddGitInfoToIndexHeader } from './vite-plugins'

// https://vitejs.dev/config/
export default defineConfig(({ mode }) => {
  const env = loadEnv(mode, process.cwd())
  return {
    plugins: [
      vue(),
      AutoImport({
        imports: ['vue', 'vue-router'],
        resolvers: [ElementPlusResolver()]
      }),
      Components({
        resolvers: [ElementPlusResolver()]
      }),
      vitePluginAddGitInfoToIndexHeader()
    ],

    server: {
      host: '0.0.0.0',
      port: Number(env.VITE_APP_PORT),
      // 代理，解决跨域问题和隐藏后端真实URL
      proxy: {
        [env.VITE_APP_FRONTEND_BASE_API]: {
          target: env.VITE_APP_BACKEND_URL,
          changeOrigin: true,
          rewrite: (path) => path.replace(new RegExp('^' + env.VITE_APP_FRONTEND_BASE_API), env.VITE_APP_BACKEND_BASE_API),
        }
      }
    },

    resolve: {
      // @别名配置
      alias: [
        {
          find: '@',
          replacement: path.resolve('./src')
        }
      ]
    },
  }
})
