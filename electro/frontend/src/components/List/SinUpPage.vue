<template>
  <Layout>
    <template #proj>
      <v-row>
        <v-col/>
        <v-col>
          <v-text-field
          label="제목"
          v-model="title"/>
        </v-col>
        <v-col/>
      </v-row>
      <v-row>
        <v-col/>
        <v-col>
          <div id="getimg" v-if="inputpoto">
            <table>
              <tr>
                <td width=100%>
                  <file-pond
                    name="bin"
                    ref="pond"
                    allow-multiple="false"
                    max-files="1"
                    accepted-file-types="image/*"
                    :server="server"
                    v-bind:files="myFiles"
                    filename="nick"
                    filenameWithoutExtension="filename"
                  />
                </td>
                <td alight="center">
                  <v-btn @click="imgokbtn(nick)">확인</v-btn>
                </td>
              </tr>
            </table>
          </div>
          <div id="getimg" v-else>
            <v-row>
              <v-col>
                <div id="poto2">
                  <v-img src="../../Logo/logo.png" contain id="grape"/>
                </div>
              </v-col>
              <v-col>
                <div id="poto3">
                  <v-row>
                    <v-col id="minanme">최소</v-col>
                    <v-col><input type="number" id="min"/></v-col>
                  </v-row>
                  <v-row>
                    <v-col id="maxanme">최대</v-col>
                    <v-col><input type="number" id="max"/></v-col>
                  </v-row>
                  <v-btn alight="center">확인</v-btn>
                </div>
              </v-col>
            </v-row>
          </div>
        </v-col>
        <v-col/>
      </v-row>
      <v-row>
        <v-col cols="5%"/>
        <v-col cols="90%">
          <v-textarea
            no-resize
            outlined
            rows="10"
            v-model="ex"
          />
        </v-col>
        <v-col cols="5%"/>
      </v-row>
      <div align="center">
        <v-btn @click="signup()" id="okbtn">확인</v-btn>
        <v-btn @click="$router.push('/')"> 취소</v-btn>
      </div>
    </template>
  </Layout>
</template>

<script>
import Layout from '@/components/Layout.vue'
import vueFilePond from 'vue-filepond'
import 'filepond/dist/filepond.min.css'
import FilePondPluginFileValidateType from 'filepond-plugin-file-validate-type'
//  import router from '../../router'
import axios from 'axios'
const FilePond = vueFilePond(FilePondPluginFileValidateType)

export default {
  components: {
    Layout,
    FilePond
  },
  data () {
    return {
      k: 1,
      filename: '',
      inputpoto: true,
      title: '',
      ex: '',
      file: 'asd',
      myFiles: [],
      num: 1,
      nick: '',
      server: {
        url: 'http://localhost:1234/file',
        process: {
          url: '/file',
          onload: (response) => { this.nick = response }
        },
        revert: {
          url: '/remove',
          method: 'POST'
        }
      }
    }
  },
  methods: {
    signup () {
      console.log('ex : ' + this.ex + ' fil : ' + this.file + ' title : ' + this.title)
      const { title, file, ex } = this
      this.$emit('listup', { title, file, ex })
    },
    submit () {},
    imgokbtn (nick) {
      //  this.inputpoto = false
      console.log('myFiles : ' + nick)
      axios.post('http://localhost:1234/file/pythonwork', { nick })
        .then(res => {
          alert('회원가입 성공')
        })
        .catch(err => {
          alert(err.response.data)
        })
    }
  }
}
</script>

<style>
.filepond--root {
  max-height: 100px;
}
.filepond--panel-root {
    background-color: #fff;
    border: 2px solid #2c3340;
}
#poto2 {
  border: solid 2px black;
  height: 300px;
  width: 440px;
}
#poto3 {
  border: solid 2px black;
  height: 300px;
  width: 150px;
}
#okbtn {
  margin-right: 40px;
}
.col {
  padding: -100px;
  margin-bottom : -10px;
}
#min {
  width: 100px;
  margin: -50px;
  border: solid 1px black;
}
#minanme {
  margin: 0px;
}
#max {
  width: 100px;
  margin: -50px;
  border: solid 1px black;
}
#maxanme {
  margin: 0px;
}
//  div { border: solid 2px black; }
</style>
