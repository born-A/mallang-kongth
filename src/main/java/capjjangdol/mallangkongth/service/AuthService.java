package capjjangdol.mallangkongth.service;

import capjjangdol.mallangkongth.domain.mypage.*;
import capjjangdol.mallangkongth.jwt.TokenDto;
import capjjangdol.mallangkongth.jwt.TokenProvider;
import capjjangdol.mallangkongth.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class AuthService {
//    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Autowired
    private MemberRepository memberRepository;
    private final AuthenticationManagerBuilder managerBuilder;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    public MemberResDto join(MemberReqDto reqDto) {
        if (memberRepository.existsByEmail(reqDto.getEmail())) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다");
        }

        Member member = reqDto.toMember(passwordEncoder);
        return MemberResDto.of(memberRepository.save(member));
    }

    public TokenDto login(MemberReqDto reqDto) {
        UsernamePasswordAuthenticationToken authenticationToken = reqDto.toAuthentication();

        Authentication authentication = managerBuilder.getObject().authenticate(authenticationToken);

        return tokenProvider.generateTokenDto(authentication);
    }

//    @Autowired
//    private Pet pet;

//    @Override
    /**
     * register
     */
//    public Long join(JoinForm joinForm){
////        dto.encryptPassword(encoder.encode(dto.getPw()));
//        Member member = joinForm.toEntity();
//        memberRepository.save(member);
//        log.info("db save successful");
//        return member.getId();
//    }
    /**
     * login
     */
//    public Long login(LoginForm loginForm){
//        Member member = loginForm.toEntity();
////        memberRepository
//
//    }
    @Transactional
//    @Override
    public boolean checkEmailDuplication(String email) {
        boolean emailDuplicate = memberRepository.existsByEmail(email);
        return emailDuplicate;
    }

//    private void validateDuplicateMember(Member member) {
//        Optional<Member> findMembers = memberRepository.findByEmail(member.getEmail());
//        if(!findMembers.empty()){
//            throw new IllegalStateException("?? ???? ?????.");
//        }
//    }
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
//    public Member findOne(Long memberId) {
//        return memberRepository.findOne(memberId);
//    }

}
