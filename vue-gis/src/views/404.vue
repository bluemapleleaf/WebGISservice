<template>
    <div class="not-found">
        <img src="../assets/404.jpeg" alt="找不到页面" />
    </div>
</template>

<script lang="ts">
export default {
    name: 'NotFound',
    components: {},
}
</script>

<style scoped>
.not-found {
    width: 100%;
    height: 100%;
    overflow: hidden;
}
.not-found img {
    width: 100%;
    height: 100%;
    object-fit: cover;
}
</style>


