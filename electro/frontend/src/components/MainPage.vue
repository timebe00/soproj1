<template>
  <v-main>
    <Layout/>
    <v-row rows="1" id="srrg">
      <v-col cols="3" align="left" mb="1">
      </v-col>
      <v-col align="right">
          <v-btn height="30px" style="margin-top:20px;" @click="$router.push('/sinup')" v-if="TF">등록</v-btn>
      </v-col>
    </v-row>
    <slot name="content" class="font" id="tables"/>
  </v-main>
</template>
<script>
import Layout from '@/components/Layout.vue'
import router from '../router'

export default {
  methods: {
    sendMessage () {
      this.message = ''
    },
    logout () {
      this.TF = false
      router.push('/')
    }
  },
  data: () => ({
    message: '',
    TF: true,
    search: ''
  }),
  components: {
    Layout
  }
}
</script>

<style>
#srrg {
  padding-top:30px;
  margin-left:60px;
  margin-right:60px;
}
</style>
