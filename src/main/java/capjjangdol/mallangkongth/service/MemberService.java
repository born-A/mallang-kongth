package capjjangdol.mallangkongth.service;


import capjjangdol.mallangkongth.repository.domain.mypage.Member;
import capjjangdol.mallangkongth.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
//@RequiredArgsConstructor
@Transactional
public class MemberService {
//    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    private MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;
//    private final TokenProvider tokenProvider;

    //    private  AuthenticationManagerBuilder authenticationManagerBuilder;
    public MemberService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * signup
     */
    public Long signUp(Member member) {
//        requestDto.encryptPassword(encoder.encode(requestDto.getPw()));
        validateDuplicateMember(member);
        checkEmailDuplication(member.getEmail());
        log.info("db save successful");
        return member.getId();
    }

    /**
     * login
     */
//    public Long login(String email, String pw) {
////        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, pw);
////        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
////        TokenDto tokendto = tokenProvider.generateToken(authentication);
////        return tokendto;
//    }
    @Transactional
//    @Override
    //이메일로 중복 확인
    public boolean checkEmailDuplication(String email) {
        boolean emailDuplicate = memberRepository.existsByEmail(email);
        return emailDuplicate;
    }

    // 이미 존재하는 회원 확인
    private void validateDuplicateMember(Member member) {
        memberRepository.findMember(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}

