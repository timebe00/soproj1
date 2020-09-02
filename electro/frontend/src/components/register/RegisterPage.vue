<template>
  <form @submit.prevent="submit">
    <div align="center">
      <h1 id="getTitle">회원가입</h1>
      <table>
        <tr>
          <td>이름</td>
          <td><input type="text" v-model="name"></td>
        </tr>
        <tr>
          <td>아이디</td>
          <td><input type="text" v-model="id"></td>
          <td><button @click="clickUse(id)">중복확인</button></td>
        </tr>
        <tr>
          <td>비밀번호</td>
          <td><input type="pw" v-model="pw"></td>
        </tr>
        <tr>
          <td>생일</td>
          <td><input type="number" v-model="br"></td>
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
      name: '',
      id: '',
      pw: '',
      br: 0
    }
  },
  methods: {
    registerOK () {
      console.log('Register Page submit Name : ' + this.name + ' ID : ' + this.id + ' PW : ' + this.pw + ' BR : ' + this.br)
      const { name, id, pw, br } = this
      this.$emit('registerOK', { name, id, pw, br })
    },
    clickUse (id) {
      console.log('clickUse : ' + id)
      axios.post('http://localhost:1234/overlap', { id })
        .then(res => {
          console.log('res : ' + res.status)
          if (res.status === 204) {
            alert('아이디 중복')
          } else {
            alert('사용 가능한 아이디')
          }
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
