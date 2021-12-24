import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  server: {
    fs: {
      // 可以为项目根目录的上一级提供服务
      allow: ['..']
    },
    port: 9091,
  }
})
