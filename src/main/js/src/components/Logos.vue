<template>
    <section class="image-holder">
        <img src="/img/vue-logo.png" alt="vue-image">
        <div class="plus">✖</div>
        <img src="img/spring-boot-logo.svg" alt="spring-boot-img">
    </section>
</template>

<script>
export default {}
</script>

<style scoped>
.image-holder {
    display: flex;
    justify-content: center;
}
img {
    width: 200px;
}
.plus {
    width: 200px;
    font-size: 200px;
}
</style>