<template>
  <show-id-page @idshow="onSubmit"/>
</template>

<script>
import ShowIdPage from '@/components/register/ShowIdPage.vue'
import router from '../../router'

export default {
  name: 'ShowId',
  components: {
    ShowIdPage
  },
  methods: {
    onSubmit (payload) {
      console.log('ShowId')
      router.push('/login')
    }
  }
}
</script>
