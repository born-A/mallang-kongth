package capjjangdol.mallangkongth.config;

import capjjangdol.mallangkongth.jwt.JwtAccessDeniedHandler;
import capjjangdol.mallangkongth.jwt.JwtAuthenticationEntryPoint;
import capjjangdol.mallangkongth.jwt.TokenProvider;
import capjjangdol.mallangkongth.service.AuthService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@Component
public class SecurityConfig{
    private final TokenProvider tokenProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable() // token localstorage에 저장 위해
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler)

                .and()
                .authorizeRequests()
                .antMatchers("/pets/**","/auth/**","/hospitalNote/**","/health/**","/walking/**").permitAll() //auth/**:login page
                .antMatchers("/member/mypage").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/auth/LoginForm")
                .defaultSuccessUrl("/auth/LoginResult")

                .permitAll()
                .and()
                .apply(new JwtSecurityConfig(tokenProvider));

        return http.build();
    }
}