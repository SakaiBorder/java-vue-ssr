<template>
    <div>
        <div> {{ count }} </div>
        <button class="btn" @click="countUp">Count Up</button>
    </div>
</template>

<script>
export default {
    data() {
        return {
            count: 0
        }
    },
    methods: {
        countUp() {
            this.count ++
        }
    }
}
</script>

<style scoped>
.btn {
    height: 50px;
    width: 100px;
    border-radius: 10px;
    background-color: black;
    color: white;
}
</style>
