package capjjangdol.mallangkongth.config;

import capjjangdol.mallangkongth.jwt.JwtFilter;
import capjjangdol.mallangkongth.jwt.TokenProvider;
import org.springframework.security.config.annotation.SecurityConfigurer;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//tokenprovider와 jwtfilter securityConfig에 적용하기 위한
public class JwtSercurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private TokenProvider tokenProvider;

    public JwtSercurityConfig(TokenProvider tokenProvider){
        this.tokenProvider = tokenProvider;
    }

//    @Override
//    public void init(HttpSecurity builder) throws Exception {
//
//    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        JwtFilter customFilter = new JwtFilter(tokenProvider);
        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
