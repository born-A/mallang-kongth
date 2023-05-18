package capjjangdol.mallangkongth.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity //spring security filter가 spring filterchain에 등록
@RequiredArgsConstructor
public class SecurityConfig {

    /*spring Security 5.7.x부터 webSecrurityConfigurerAdapter deprecated
    -> filterChain은 return값과 bean 등록으로 component 기반 보안 설정 가능
     */

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        /*
        permitAll :login, sign Page
         */
        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/login/loginForm","/login").permitAll()
//                .antMatchers("/members/test").hasRole("USER")
                .anyRequest().authenticated();
        return http.build();
    }

    //password 암호화 메서드 가진 클래스
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
