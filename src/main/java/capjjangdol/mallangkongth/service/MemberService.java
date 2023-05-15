package capjjangdol.mallangkongth.service;

import capjjangdol.mallangkongth.jwt.TokenProvider;
import capjjangdol.mallangkongth.repository.domain.mypage.Member;
import capjjangdol.mallangkongth.repository.MemberRepository;
import capjjangdol.mallangkongth.dto.MemberSignUpRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    public MemberService(PasswordEncoder passwordEncoder, TokenProvider tokenProvider) {
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
    }

//    @Autowired
//    private Pet pet;

//    @Override
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

    @Transactional
//    @Override
    public boolean checkEmailDuplication(String email) {
        boolean emailDuplicate = memberRepository.existsByEmail(email);
        return emailDuplicate;
    }
    /**
     * login
     */
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

    public String login(MemberSignUpRequestDto memberSignUpRequestDto) {
        Member member = memberRepository.findByEmail(memberSignUpRequestDto.getEmail())
                .orElseThrow(()-> new IllegalStateException("가입되지 않은 EMAIL"));
        if (!passwordEncoder.matches(memberSignUpRequestDto.getPw(), member.getPw())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        // 로그인에 성공하면 email, roles 로 토큰 생성 후 반환
        return tokenProvider.createToken(member.getEmail(), member.getRoleType());
    }
    }
