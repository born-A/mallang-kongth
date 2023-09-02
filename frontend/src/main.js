import { createApp } from 'vue';
//import App from './App.vue';
import router from './router';
import LoginForm from "@/components/LoginForm.vue";

createApp(LoginForm).use(router).mount('#app')