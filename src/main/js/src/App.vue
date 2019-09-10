<template>
    <div id="app">
        <Logos></Logos>
        <h1>Vue.js + Spring Boot SSR</h1>
        <main>
            <router-view></router-view>
        </main>
        <router-link to="/">top</router-link>
        <router-link to="/second">second</router-link>
    </div>
</template>

<script>
import Logos from './components/Logos.vue'

export default {
    components: {
        Logos
    },
}
</script>

<style>
html, body {
    width: 100%;
    height: 100vh;
}
#app {
    margin: auto;
    text-align: center;
}
</style>

