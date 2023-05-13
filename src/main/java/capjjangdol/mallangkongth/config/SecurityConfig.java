package capjjangdol.mallangkongth.config;

import capjjangdol.mallangkongth.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    @Autowired
    private MemberService memberService;
    @Bean
    /*spring Security 5.7.x부터 webSecrurityConfigurerAdapter deprecated
    -> filterChain은 return값과 bean 등록으로 component 기반 보안 설정 가능
     */
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        /*
        permitAll :login, sign Page
         */
        http
                .authorizeRequests()
                .antMatchers("/login", "/signup").permitAll()
                .anyRequest().authenticated();

        http
                .formLogin()
                .loginPage("/login")    // GET 요청 (login form을 보여줌)
                .loginProcessingUrl("/auth")    // POST 요청 (login 창에 입력한 데이터를 처리)
                .usernameParameter("email")	// login에 필요한 id 값을 email로 설정 (default는 username)
                .passwordParameter("password")	// login에 필요한 password 값을 password(default)로 설정
                .defaultSuccessUrl("/");	// login에 성공하면 /로 redirect
        http
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/");	// logout에 성공하면 /로 redirect

        return http.build();
    }
    @Bean
    //webSecrurityConfigurerAdapter의 Configure() 대신 SecurityFilterChain의 WebSecurityCustomizer bean 등록
    public WebSecurityCustomizer webSecurityCustomizer(){
        return (web) -> web.ignoring();
    }
    @Bean
    //password 암호화 메서드 가진 클래스
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
