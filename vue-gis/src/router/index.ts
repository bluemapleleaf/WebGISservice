import { createRouter, createWebHistory } from 'vue-router'

const routerHistory = createWebHistory()
const router = createRouter({
    history: routerHistory,
    routes: [
        {
            path: '/',
            name: 'Index',
            component: () => import('../views/Index.vue')
        },
        {
            path: '/login',
            name: 'Login',
            component: () => import('../views/LoginRegister.vue')
        },
        {
            path: '/:catchAll(.*)',
            name: '404',
            component: () => import('../views/404.vue')
        },
    ]
})

export default router