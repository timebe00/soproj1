<template>
  <v-main>
    <Layout/>
    <v-row rows="1" id="srrg">
      <v-col cols="3" align="left" mb="1">
        <v-text-field
        v-model="search"
        append-icon="mdi-magnify"
        label="Search"
        single-line
        hide-details/>
      </v-col>
    </v-row>
    <v-simple-table id="tables">
      <template v-slot:default padding="1px">
        <thead padding="1px" margin="1px">
          <tr>
            <th class="text-center" width="10%">No.</th>
            <th class="text-center" width="70%">제목</th>
            <th class="text-center" width="20%">작성자</th>
          </tr>
        </thead>
        <tbody>
          <tr @click="read(board.memberNo)"
            v-for="board in mainboard" :key="board.memberNo">
            <td class="text-center" >{{ board.memberNo }}</td>
            <td class="text-center">{{ board.title }}</td>
            <td class="text-center">{{ board.id }}</td>
          </tr>
        </tbody>
      </template>
    </v-simple-table>
  </v-main>
</template>
<script>
import Layout from '@/components/Layout.vue'
import router from '../router'
import axios from 'axios'
import { mapGetters } from 'vuex'
export default {
  computed: {
    ...mapGetters(['getid'])
  },
  data: () => ({
    message: '',
    TF: false,
    search: '',
    num: 0
  }),
  components: {
    Layout
  },
  props: {
    mainboard: {
      type: Array
    }
  },
  methods: {
    sendMessage () {
      this.message = ''
    },
    logout () {
      this.TF = false
      router.push('/')
    },
    read (memberNo) {
      console.log('number : ' + memberNo)
      axios.post('http://localhost:1234/member/readmember', { memberNo })
        .then(res => {
          console.log('res.data : ' + res.data)
          router.push({ name: 'Show', params: { title: res.data.title, file: res.data.file, ex: res.data.ex } })
        })
        .catch(err => {
          alert(err.response.data)
        })
    },
    num () {
      this.num = this.num + 1
    }
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
