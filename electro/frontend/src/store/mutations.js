import {
  Login,
  FINDONE
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
  }
}
