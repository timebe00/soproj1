<template>
  <register-page @registerOK="onSubmit"/>
</template>

<script>
import RegisterPage from '@/components/register/RegisterPage.vue'
import router from '../../router'
import axios from 'axios'

export default {
  name: 'Login',
  components: {
    RegisterPage
  },
  methods: {
    onSubmit (payload) {
      console.log('Register submit Name : ' + payload.name + ' ID : ' + payload.id + ' PW : ' + payload.pw + ' BR : ' + payload.br)
      const { name, id, pw, br } = payload
      axios.post('http://localhost:1234/register/register', { name, id, pw, br })
        .then(res => {
          alert('회원가입 성공')
          router.push('/')
        })
        .catch(err => {
          alert(err.response.data)
        })
    }
  }
}
</script>
