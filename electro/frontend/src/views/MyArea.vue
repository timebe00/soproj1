<template>
  <my-area-list :myboard="myboard" v-on:del="del"/>
</template>

<script>
import MyAreaList from '@/components/MyAreaList.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
  name: 'MyArea',
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
    ...mapActions(['myBoarder']),
    del (memberNo) {
      axios.post('http://localhost:1234/member/deletemember', { memberNo })
        .then(res => {
          this.myBoarder(this.id)
        })
        .catch(err => {
          alert(err.response.data)
        })
    }
  },
  mounted () {
    this.id = this.saveid
    console.log(this.id)
    this.myBoarder(this.id)
  }
}
</script>
