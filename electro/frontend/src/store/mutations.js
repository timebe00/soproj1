import {
  Login,
  FINDONE,
  MAINBOARD,
  MYBOARD
} from './mutation-types'

//  import axios from 'axios'
//  import cookies from 'vue-cookies'

export default {
  [Login] (state, payload) {
    console.log('mu_login')
    state.lists = payload
  },
  [FINDONE] (state, payload) {
    console.log('FINDONE : ' + payload)
    state.saveid = payload
  },
  [MAINBOARD] (state, mainboard) {
    state.mainboard = mainboard
  },
  [MYBOARD] (state, myboard) {
    state.myboard = myboard
  }
}
