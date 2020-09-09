import {
  FINDONE,
  MAINBOARD
} from './mutation-types'

import axios from 'axios'
//  import router form '../router'

export default {
  rememberid ({ commit }, a) {
    console.log('asd: ' + a)
    commit(FINDONE, a)
  },
  mainBoarder ({ commit }) {
    console.log('qwe')
    return axios.get('http://localhost:1234/member/mainmember')
      .then(res => {
        console.log('res.data : ' + res.data)
        commit(MAINBOARD, res.data)
      })
  }
}
