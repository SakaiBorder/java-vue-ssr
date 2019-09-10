import Vue from 'vue'
import Router from 'vue-router'
import TopPage from '../pages/TopPage.vue'
import SecondPage from '../pages/SecondPage.vue'

Vue.use(Router)

export function createRouter() {
    return new Router({
        mode: 'history',
        routes: [
            { path: '/', name: 'top', component: TopPage },
            { path: '/second', name: 'second', component: SecondPage}
        ]
    })
}
