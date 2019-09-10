import { createApp } from './app'

const { app, router, store } = createApp()

router.onReady(() => {
    if (window.__INITIAL_STATE__) {
        store.replaceState(Object.assign(window.__INITIAL_STATE__, { route: store.state.route} ))
    }
    app.$mount('#app', true)
})
