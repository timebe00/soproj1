<template>
  <find-pw-page @findpw="onSubmit"/>
</template>

<script>
import FindPwPage from '@/components/register/FindPwPage.vue'
import router from '../../router'
import axios from 'axios'

export default {
  name: 'FindPw',
  components: {
    FindPwPage
  },
  methods: {
    onSubmit (payload) {
      const { name, id, br } = payload
      axios.post('http://localhost:1234/findpw', { name, id, br })
        .then(res => {
          if (res.status === 204) {
            alert('잘못 입력하셨습니다.  :  ')
          } else {
            alert('res.data.id : ' + res.data.id)
            router.push('/login/havepw', res.data.id)
          }
        })
        .catch(err => {
          alert(err.response.data)
        })
    }
  }
}
</script>
