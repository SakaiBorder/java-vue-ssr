import Vue from 'vue'
import { createRouter } from './router/router'
import store from './store/store'
import App from './App.vue'

export function createApp() {

    const router = createRouter()

    const app = new Vue({
        router,
        store,
        render: h => h(App)
    })

    return { app, router, store }
}