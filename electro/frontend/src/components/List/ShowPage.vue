<template>
  <Layout>
    <template #proj>
      <v-row>
        <v-col/>
        <v-col>
          <div id="title">{{ title }}</div>
        </v-col>
        <v-col/>
      </v-row>
      <v-row>
        <v-col/>
        <v-col>
          <div id="getpoto">
            <v-row>
              <v-col>
                <div id="poto2">{{ file }}</div>
              </v-col>
              <v-col>
                <div id="poto3">
                  <v-row>
                    <v-col>
                      {{ k }} 중심점
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
          <div id="bodytext">
            {{ ex }}
          </div>
        </v-col>
        <v-col cols="5%"/>
      </v-row>
      <div align="center">
        <v-btn  @click="$router.push('/')">메인으로</v-btn>
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
    inputpoto: true
  }),
  props: {
    title: String,
    file: String,
    ex: String
  },
  methods: {
    signup () {
      console.log('ex : ' + this.ex + ' fil : ' + this.fil + ' title : ' + this.title)
      router.push('/')
    }
  }
}
</script>

<style>
#title {
  margin-top: 40px;
  height: 30px;
  border-bottom: solid 1px black;
}
#bodytext {
  border: solid 1px black;
}
//  div { border: solid 2px black; }
</style>
