<template>
  <find-id-page @findid="onSubmit"/>
</template>

<script>
import FindIdPage from '@/components/register/FindIdPage.vue'
import router from '../../router'

export default {
  name: 'FindId',
  components: {
    FindIdPage
  },
  methods: {
    onSubmit (payload) {
      console.log('Login onSubmit() Name : ' + payload.username + ' BR : ' + payload.birthday)
      router.push('/login/showid')
    }
  }
}
</script>
