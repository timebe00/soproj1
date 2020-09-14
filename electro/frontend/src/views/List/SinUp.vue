<template>
  <sin-up-page @listup="onSubmit"/>
</template>

<script>
import SinUpPage from '../../components/List/SinUpPage.vue'
import axios from 'axios'
import router from '../../router'
import { mapGetters } from 'vuex'

export default {
  name: 'SinUp',
  components: {
    SinUpPage
  },
  data: () => ({
    id: ''
  }),
  computed: {
    ...mapGetters(['getid'])
  },
  methods: {
    onSubmit (payload) {
      payload.id = this.id
      const { title, file, ex, id } = payload
      console.log('payload.id : ' + payload.id)
      axios.post('http://localhost:1234/member/sinup', { title, file, ex, id })
        .then(res => {
          alert('확인')
          router.push('/myarea')
        })
        .catch(err => {
          alert(err.response.data)
        })
    }
  },
  mounted (payload) {
    console.log('getid : ' + this.getid)
    this.id = this.getid
  }
}
</script>

<style>
</style>
