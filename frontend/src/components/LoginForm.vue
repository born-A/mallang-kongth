
<template>
  <div>
    <h2>Login</h2>
    <form @submit.prevent="login">
      <div>
        <label for="email">Email:</label>
        <input type="email" id="email" v-model="formData.email" />
      </div>
      <div>
        <label for="password">Password:</label>
        <input type="password" id="password" v-model="formData.password" />
      </div>
      <button type="submit">Login</button>
    </form>
    <p v-if="message">{{ message }}</p>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  data() {
    return {
      formData: {
        email: '',
        password: ''
      },
      message: ''
    }
  },
  methods: {
    login() {
      // Vue.js에서 서버로 HTTP POST 요청을 보냅니다.
      const formData = {
        email: this.formData.email,
        password: this.formData.password
      };

      axios.post('/api/login', formData)
          .then(response => {
            // 서버에서 반환한 응답 처리
            if (response.status === 200) {
              // 로그인 성공
              this.message = 'Login successful';
              // 성공 시 필요한 작업 수행 (예: 페이지 리디렉션)
            } else {
              // 로그인 실패
              this.message = 'Login failed';
              // 실패 시 필요한 작업 수행 (예: 에러 처리)
            }
          })
          .catch(error => {
            // 에러 처리
            this.message = 'Error: ' + error.message;
          });
    }
  }
};
</script>

<style scoped>

</style>