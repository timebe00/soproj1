<template>
  <main-page>
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
            <tr @click="$router.push('/show')">
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

export default {
  name: 'Home',
  components: {
    MainPage
  },
  methods: {
  },
  data () {
    return {
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
