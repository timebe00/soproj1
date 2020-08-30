<template>
  <form @submit.prevent="submit">
    <div align="center">
      <h1 id="getTitle">아이디 찾기</h1>
      <table>
        <tr>
          <td>이름</td>
          <td><input type="text" v-model="username"></td>
        </tr>
        <tr>
          <td>생년월일</td>
          <td><input type="number" v-model="birthday"></td>
        </tr>
      </table>

      <table>
        <tr>
          <td><button @click="findid()">확인</button></td>
          <td><button @click="$router.push('/login')">취소</button></td>
        </tr>
      </table>
    </div>
  </form>
</template>

<script>
export default {
  name: 'FindIdPage',
  data () {
    return {
      username: '',
      birthday: 0
    }
  },
  methods: {
    findid () {
      console.log('Find ID Page submit Name : ' + this.username + ' BR : ' + this.birthday)
      const { username, birthday } = this
      this.$emit('findid', { username, birthday })
    },
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
