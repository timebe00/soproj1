<template>
  <form @submit.prevent="submit">
    <div align="center">
      <h1 id="getTitle">아이디 찾기</h1>
      <table>
        <tr>
          <td>ID</td>
          <td>{{ showid }}</td>
        </tr>
      </table>

      <table>
        <tr>
          <td><button @click="$router.push('/login')">확인</button></td>
        </tr>
      </table>
    </div>
  </form>
</template>

<script>
export default {
  name: 'FindIdPage',
  data: () => ({
    showid: ''
  }),
  methods: {
    submit () {}
  }
}
</script>

<style>
#getTitle {
  margin-top: 10%;
}
table {
  margin-top: 20px;
}
td {
  padding: 5px;
}
button {
  padding-right: 40px;
  padding-left: 40px;
}
</style>
