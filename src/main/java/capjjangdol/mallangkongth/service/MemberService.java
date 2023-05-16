package capjjangdol.mallangkongth.service;

import capjjangdol.mallangkongth.dto.TokenDto;
import capjjangdol.mallangkongth.jwt.TokenProvider;
import capjjangdol.mallangkongth.repository.domain.mypage.Member;
import capjjangdol.mallangkongth.repository.MemberRepository;
import capjjangdol.mallangkongth.dto.MemberSignUpRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class MemberService {
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Autowired
    private MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    private  AuthenticationManagerBuilder authenticationManagerBuilder;
    public MemberService(PasswordEncoder passwordEncoder, TokenProvider tokenProvider) {
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
    }

    /**
     * signup
     */
    public Long signUp(MemberSignUpRequestDto requestDto){
        requestDto.encryptPassword(encoder.encode(requestDto.getPw()));
        Member member = requestDto.toEntity();
        memberRepository.save(member);
        log.info("db save successful");
        validateDuplicateMember(member);
        checkEmailDuplication(member.getEmail());
        return Long.valueOf(member.getEmail());
    }
    /**
     * login
     */
    public TokenDto login(String email, String pw) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, pw);
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        TokenDto tokendto = tokenProvider.generateToken(authentication);
        return tokendto;
    }
    @Transactional
//    @Override
    public boolean checkEmailDuplication(String email) {
        boolean emailDuplicate = memberRepository.existsByEmail(email);
        return emailDuplicate;
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findMember(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }
    public Optional<Member> findMembers() {
        return memberRepository.findAll();
    }
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }

    }
