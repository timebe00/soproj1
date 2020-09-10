import {
  FINDONE,
  MAINBOARD,
  MYBOARD
} from './mutation-types'

import axios from 'axios'
//  import router form '../router'

export default {
  rememberid ({ commit }, a) {
    console.log('asd: ' + a)
    commit(FINDONE, a)
  },
  mainBoarder ({ commit }) {
    return axios.get('http://localhost:1234/member/mainmember')
      .then(res => {
        console.log('res.data : ' + res.data)
        commit(MAINBOARD, res.data)
      })
  },
  async myBoarder ({ commit }, id) {
    console.log('action id : ' + id)
    return axios.post('http://localhost:1234/member/mymember', { id })
      .then(res => {
        commit(MYBOARD, res.data)
      })
  }
}
