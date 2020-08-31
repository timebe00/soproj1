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
      <v-simple-table id="tables">
        <template v-slot:default padding="1px">
          <thead padding="1px" margin="1px">
            <tr>
              <th class="text-center" width="10%">No.</th>
              <th class="text-center" width="70%">제목</th>
              <th class="text-center" width="20%">날짜</th>
            </tr>
          </thead>
          <tbody>
            <tr @click="$router.push('/sinup')">
              <td class="text-center">100</td>
              <td class="text-center">100</td>
              <td class="text-center">100</td>
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

export default {
  name: 'Home',
  components: {
    MainPage
  },
  methods: {
    home () {
      (window.location.pathname !== '/myarea/relode') ? router.push('/myarea/relode') : router.go(0)
    }
  },
  data: () => ({
    drawer: false,
    left: false
  })
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
