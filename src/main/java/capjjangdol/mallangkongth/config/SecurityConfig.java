//package capjjangdol.mallangkongth.config;
//
//import capjjangdol.mallangkongth.service.MemberService;
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@AllArgsConstructor
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private MemberService memberService;
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests().antMatchers("/main").authenticated()
//                .and()
//                .formLogin()
//                .defaultSuccessUrl("/main", true)
//                .permitAll()
//                .and()
//                .logout()
//    }
//    }
//}