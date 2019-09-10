<template>
    <div id="app">
        <div>App</div>
        <div>
            <router-view></router-view>
        </div>
        <router-link to="/">top</router-link>
        <router-link to="/second">second</router-link>
    </div>
</template>

<script>
export default {

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

