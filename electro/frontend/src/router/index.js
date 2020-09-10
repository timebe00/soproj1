//  뷰 시작
import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
//  로그인 관련
import Login from '../views/register/Login.vue'
import Register from '../views/register/Register.vue'
import FindId from '../views/register/FindId.vue'
import FindPw from '../views/register/FindPw.vue'
import ReLode from '../views/register/ReLode.vue'
import ChangePw from '../views/register/ChangePw.vue'
import ShowId from '../views/register/ShowId.vue'
import HavePw from '../views/register/HavePw.vue'
//  리스트 관련
import MyArea from '../views/MyArea.vue'
import SinUp from '../views/List/SinUp.vue'
import Show from '../views/List/Show.vue'

Vue.use(VueRouter)
const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home

  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/register',
    name: 'Register',
    component: Register
  },
  {
    path: '/login/findid',
    name: 'FindId',
    components: {
      default: FindId
    }
  },
  {
    path: '/login/findpw',
    name: 'FindPw',
    component: FindPw,
    props: true
  },
  {
    path: '/login/showid',
    name: 'ShowId',
    components: {
      default: ShowId
    },
    props: {
      default: true
    }
  },
  {
    path: '/myarea',
    name: 'MyArea',
    component: MyArea
  },
  {
    path: '/myarea/relode',
    name: 'ReLode',
    component: ReLode
  },
  {
    path: '/myarea/relode/changepw',
    name: 'ChangePw',
    component: ChangePw
  },
  {
    path: '/login/havepw',
    name: 'HavePw',
    component: HavePw
  },
  {
    path: '/sinup',
    name: 'SinUp',
    component: SinUp
  },
  {
    path: '/show',
    name: 'Show',
    components: {
      default: Show
    },
    props: {
      default: true
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
