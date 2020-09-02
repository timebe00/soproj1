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
          <div id="getpoto" v-if="inputpoto">
            <v-file-input
              label="File input"
              filled
              v-model="fil"/>
          </div>
          <div id="getpoto" v-else>
            <v-row>
              <v-col>
                <div id="poto2"/>
              </v-col>
              <v-col>
                <div id="poto3">
                  <v-row>
                    <v-col>
                      {{ k }}중심점
                    </v-col>
                  </v-row>
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
import router from '../../router'

export default {
  components: {
    Layout
  },
  data: () => ({
    k: 1,
    inputpoto: true,
    title: '',
    ex: '',
    fil: ''
  }),
  methods: {
    signup () {
      console.log('ex : ' + this.ex + ' fil : ' + this.fil + ' title : ' + this.title)
      router.push('/')
    }
  }
}
</script>

<style>
#poto2 {
  border: solid 2px black;
  height: 270px;
  width: 440px;
}
#poto3 {
  border: solid 2px black;
  height: 270px;
  width: 150px;
}
#okbtn {
  margin-right: 40px;
}
//  div { border: solid 2px black; }
</style>
