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
    proxy: {
      '/api': {
        target: 'http://localhost:9090/',
        changeOrigin: true,
        rewrite: path => path.replace(/^\/api/, '')
      }
    },
    port: 9091,
  }
})
