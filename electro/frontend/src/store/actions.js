import {
  FINDONE
} from './mutation-types'

//  import axios from 'axios'
//  import router form '../router'

export default {
  rememberid ({ commit }, a) {
    console.log('asd: ' + a)
    commit(FINDONE, a)
  }
}
