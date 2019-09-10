<template>
    <section>
        <h2>This is 2nd page</h2>
        <div>{{ word }}</div>
        <Counter></Counter>
    </section>
</template>

<script>
import Counter from '../components/Counter.vue'

export default{
    components: {
        Counter
    },
    computed: {
        word() {
            return this.$store.getters.getWord
        }
    },
    mounted() {
        if (!window.__INITIAL_STATE__) {
            this.getWord()
        }
    },
    methods: {
        getWord() {
            this.$store.dispatch('getWordAction')
        }
    }
}
</script>

<style scoped>
div > div:nth-child(2) {
    height: 20px;
}
</style>