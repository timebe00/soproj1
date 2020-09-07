<template>
  <v-main>
    <v-app-bar clipped-right color="blue" height="110" dark>
      <v-col cols="1">
        <v-img src="../Logo/logo.png" contain @click="$router.push('/')"/>
      </v-col>
      <v-toolbar-title><div @click="$router.push('/')">Proj</div></v-toolbar-title>
      <slot name="iconinput"/>
      <v-spacer></v-spacer>
      <div id="mainhead" v-if="TF">
        <v-btn @click="$router.push('/myarea')" style="margin-right: 10px">
          마이페이지
        </v-btn>
        <v-btn @click="logout()">
          로그아웃
        </v-btn>
      </div>
      <div id="mainhead" v-else>
        <v-btn @click="$router.push('/login')" style="margin-right: 10px">
          로그인
        </v-btn>
        <v-btn @click="$router.push('/register')">
          회원가입
        </v-btn>
      </div>
    </v-app-bar>
    <slot name="proj"/>
  </v-main>
</template>

<script>
//  import axios from 'axios'
import { mapActions, mapGetters } from 'vuex'
import router from '../router'

export default {
  computed: {
    ...mapGetters(['getid'])
  },
  data: () => ({
    id: '',
    TF: false,
    havelogout: 'null'
  }),
  methods: {
    ...mapActions(['rememberid']),
    logout () {
      this.rememberid(this.havelogout)
      this.TF = false
      router.push('/')
    }
  },
  mounted (payload) {
    console.log('getid : ' + this.getid)
    if (this.getid === 'null') {
      this.TF = false
    } else {
      this.TF = true
    }
  }
}
</script>

<style>
</style>
