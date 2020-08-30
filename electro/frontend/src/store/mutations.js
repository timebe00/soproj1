import {
  Login
} from './mutation-types'

import axios from 'axios'
import cookies from 'vue-cookies'

export default {
  [Login] (state, payload) {
    console.log("mu_login")
    state.lists = payload
  },
}
