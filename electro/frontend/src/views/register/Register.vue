<template>
  <register-page @registerOK="onSubmit"/>
</template>

<script>
import RegisterPage from '@/components/register/RegisterPage.vue'
import router from '../../router'

export default {
  name: 'Login',
  components: {
    RegisterPage
  },
  methods: {
    onSubmit (payload) {
      console.log('Register submit Name : ' + payload.username + ' ID : ' + payload.userid + ' PW : ' + payload.password + ' BR : ' + payload.birthday)
      router.push('/')
    }
  }
}
</script>
