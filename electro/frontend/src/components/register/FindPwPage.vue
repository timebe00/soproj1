<template>
  <form @submit.prevent="submit">
    <div align="center">
      <h1 id="getTitle">비밀번호 찾기</h1>
      <table>
        <tr>
          <td>이름</td>
          <td><input type="text" v-model="name"></td>
        </tr>
        <tr>
          <td>아이디</td>
          <td><input type="text" v-model="id"></td>
        </tr>
        <tr>
          <td>생일</td>
          <td><input type="number" v-model="br"></td>
        </tr>
      </table>
      <table>
        <tr>
          <td><button @click="findpw()">확인</button></td>
          <td><button @click="$router.push('/login')">취소</button></td>
        </tr>
      </table>
    </div>
  </form>
</template>

<script>
export default {
  name: 'FindPwPage',
  data () {
    return {
      id: '',
      name: '',
      br: 0
    }
  },
  methods: {
    findpw () {
      console.log('Find PW Page submit Name : ' + this.name + ' ID : ' + this.id + ' BR : ' + this.br)
      const { name, id, br } = this
      this.$emit('findpw', { name, id, br })
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
