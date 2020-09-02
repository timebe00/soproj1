<template>
  <change-pw-page @repassword="onSubmit"/>
</template>

<script>
import ChangePwPage from '@/components/register/ChangePwPage.vue'
import router from '../../router'
import axios from 'axios'

export default {
  name: 'ChangePw',
  components: {
    ChangePwPage
  },
  methods: {
    onSubmit (payload) {
      const { pw } = payload
      axios.post('http://localhost:1234/uplodpw', { pw })
        .then(res => {
          alert('비밀번호 변경 성공')
        })
        .catch(err => {
          alert(err.response.data)
        })
      router.push('/login')
    }
  }
}
</script>
