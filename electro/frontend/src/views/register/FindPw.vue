<template>
  <find-pw-page @findpw="onSubmit"/>
</template>

<script>
import FindPwPage from '@/components/register/FindPwPage.vue'
import router from '../../router'

export default {
  name: 'FindPw',
  components: {
    FindPwPage
  },
  methods: {
    onSubmit (payload) {
      console.log('Login onSubmit() ID : ' + payload.userid + ' Name : ' + payload.username + ' BR : ' + payload.birthday)
      router.push('/login/havepw')
    }
  }
}
</script>
