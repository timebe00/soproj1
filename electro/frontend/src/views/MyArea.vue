<template>
  <my-area-list :myboard="myboard"/>
</template>

<script>
import MyAreaList from '@/components/MyAreaList.vue'
import { mapState, mapActions } from 'vuex'

export default {
  name: 'Home',
  components: {
    MyAreaList
  },
  data: () => ({
    id: ''
  }),
  computed: {
    ...mapState(['myboard']),
    ...mapState(['saveid'])
  },
  methods: {
    ...mapActions(['myBoarder'])
  },
  mounted () {
    this.id = this.saveid
    console.log(this.id)
    this.myBoarder(this.id)
  }
}
</script>
