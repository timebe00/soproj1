<template>
  <main-page>
    <template #iconinput>
      <v-app-bar-nav-icon clipped-right @click.stop="drawer = !drawer"/>
      <v-navigation-drawer v-model="drawer">
        <v-list-item @click.stop="left = !left">
          <v-list-item-action>
            <v-icon>mdi-key-variant</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title @click="home">비밀번호 변경</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-navigation-drawer>
    </template>
    <template #content>
      <v-simple-table
        id="tables">
        <template v-slot:default padding="1px">
          <thead padding="1px" margin="1px">
            <tr>
              <th class="text-center" width="10%">No.</th>
              <th class="text-center" width="70%">제목</th>
              <th class="text-center" width="20%">삭제</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="board in myboard" :key="board.memberNo">
              <td class="text-center" @click="read(board.memberNo)">{{ board.memberNo }}</td>
              <td class="text-center" @click="read(board.memberNo)">{{ board.title }}</td>
              <th class="text-center" @click="dle(board.memberNo)"><v-btn>삭제</v-btn></th>
            </tr>
          </tbody>
        </template>
      </v-simple-table>
    </template>
  </main-page>
</template>

<script>
import MainPage from '@/components/MainPage.vue'
import router from '../router'
import axios from 'axios'

export default {
  name: 'MyArealist',
  components: {
    MainPage
  },
  data: () => ({
    drawer: false,
    left: false
  }),
  props: {
    myboard: {
      type: Array
    }
  },
  methods: {
    home () {
      (window.location.pathname !== '/myarea/relode') ? router.push('/myarea/relode') : router.go(0)
    },
    dle (memberNo) {
      console.log('memberNo : ' + memberNo)
      this.$emit('del', memberNo)
    },
    read (memberNo) {
      console.log('memberNo : ' + memberNo)
      axios.post('http://localhost:1234/member/readmember', { memberNo })
        .then(res => {
          console.log('res.data : ' + res.data)
          router.push({ name: 'Show', params: { title: res.data.title, file: res.data.file, ex: res.data.ex } })
        })
        .catch(err => {
          alert(err.response.data)
        })
    }
  }
}
</script>

<style>
#tables {
  padding-top:0px;
  margin-left:60px;
  margin-right:60px;
  margin-top:-30px
}
</style>
