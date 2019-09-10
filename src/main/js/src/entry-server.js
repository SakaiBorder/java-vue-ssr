import { createApp } from './app'

const { app, router, store } = createApp()

router.push(route)

router.onReady(() => {
    renderVueComponentToString(app, (err, res) => {
        rendered = String(res)
    })
})
