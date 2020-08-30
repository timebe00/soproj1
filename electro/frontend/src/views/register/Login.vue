<template>
  <login-page @login="onSubmit"/>
</template>

<script>
import LoginPage from '@/components/register/LoginPage.vue'
import router from '../../router'

export default {
  name: 'Login',
  components: {
    LoginPage
  },
  methods: {
    onSubmit (payload) {
      console.log('Login onSubmit() ID : ' + payload.userid + ' PW : ' + payload.password)
      router.push('/')
    }
  }
}
</script>
