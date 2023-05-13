package capjjangdol.mallangkongth.service;

import capjjangdol.mallangkongth.repository.domain.mypage.Member;
import capjjangdol.mallangkongth.repository.MemberRepository;
import capjjangdol.mallangkongth.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

//    @Autowired
//    private Pet pet;

//    @Override
    /**
     * register
     */
    public Long join(MemberDto.RequestMemberDto dto){
        dto.encryptPassword(encoder.encode(dto.getPw()));
        Member member = dto.toEntity();
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
}
