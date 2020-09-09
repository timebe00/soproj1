<template>
  <my-list :mainboard="mainboard"/>
</template>

<script>
import MyList from '@/components/MyList.vue'
import { mapState, mapActions } from 'vuex'

export default {
  name: 'Home',
  components: {
    MyList
  },
  computed: {
    ...mapState(['mainboard'])
  },
  data: () => ({
  }),
  methods: {
    ...mapActions(['mainBoarder'])
  },
  mounted () {
    this.mainBoarder()
  }
}
</script>

<style>
</style>
