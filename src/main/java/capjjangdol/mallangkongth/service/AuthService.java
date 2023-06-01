package capjjangdol.mallangkongth.service;

import capjjangdol.mallangkongth.domain.mypage.*;
//import capjjangdol.mallangkongth.jwt.TokenDto;
//import capjjangdol.mallangkongth.jwt.TokenProvider;
import capjjangdol.mallangkongth.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static jdk.nashorn.internal.objects.NativeArray.map;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {
//    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Autowired
    private MemberRepository memberRepository;
//    private final AuthenticationManagerBuilder managerBuilder;
    private final PasswordEncoder passwordEncoder;
//    private final TokenProvider tokenProvider;

    public Member join(Member member) {
        if (memberRepository.existsByEmail(member.getEmail())) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다");
        }
        return memberRepository.save(member);
    }

//    public Member login(LoginForm loginForm) throws IllegalAccessException {
//
//       }



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(email);

        if (member == null) {
            throw new UsernameNotFoundException(email);
        }
        return User.builder()
                .username(member.getEmail())
                .password(member.getPw())
                .roles(member.getRoleType().toString())
                .build();
    }
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member login(LoginForm loginForm) throws IllegalAccessException {
        Member member = memberRepository.findByEmail(loginForm.getEmail());
        if(member.equals(null)){
            throw new IllegalAccessException("아이디가 맞지 않습니다.");
        }
        if(!loginForm.getPw().equals(member.getPw())){
            throw new IllegalAccessException("비밀번호가 맞지 않습니다.");}
        return member;}
}
