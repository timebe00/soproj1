<template>
  <Layout>
    <template #proj>
      <v-row>
        <v-col text-align="left">
          제목
        </v-col>
        <v-col>
          <v-text-field/>
        </v-col>
        <v-col>
        </v-col>
      </v-row>
      <v-row>
        <v-col cols="5%"/>
        <v-col id="textAr" cols="90%">
          <v-textarea
            no-resize
            rows="10"
            :value="value"
          />
        </v-col>
        <v-col cols="5%"/>
      </v-row>
    </template>
  </Layout>
</template>

<script>
import Layout from '@/components/Layout.vue'

export default {
  components: {
    Layout
  }
}
</script>

<style>
#textAr {
  border: 2px solid black
}
</style>
