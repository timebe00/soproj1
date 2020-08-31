<template>
  <form @submit.prevent="submit">
    <div align="center">
      <h1 id="getTitle">회원가입</h1>
      <table>
        <tr>
          <td>이름</td>
          <td><input type="text" v-model="username"></td>
        </tr>
        <tr>
          <td>아이디</td>
          <td><input type="text" v-model="userid"></td>
          <td><button @click="clickUse(userid)">중복확인</button></td>
        </tr>
        <tr>
          <td>비밀번호</td>
          <td><input type="password" v-model="password"></td>
        </tr>
        <tr>
          <td>생일</td>
          <td><input type="number" v-model="birthday"></td>
        </tr>
      </table>

      <table>
        <tr>
          <td><button @click="registerOK()">확인</button></td>
          <td><button @click="$router.push('/')" type="null">취소</button></td>
        </tr>
      </table>
    </div>
  </form>
</template>

<script>
import axios from 'axios'

export default {
  name: 'LoginPage',
  data () {
    return {
      username: '',
      userid: '',
      password: '',
      birthday: 0
    }
  },
  methods: {
    registerOK () {
      console.log('Register Page submit Name : ' + this.username + ' ID : ' + this.userid + ' PW : ' + this.password + ' BR : ' + this.birthday)
      const { username, userid, password, birthday } = this
      this.$emit('registerOK', { username, userid, password, birthday })
    },
    clickUse (userid) {
      console.log('clickUse : ' + userid)
      axios.get('http://localhost:1234/overlap', { userid })
        .then(res => {
          console.log('res : ' + res)
        })
        .catch(err => {
          alert(err.response.data.message)
        })
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
