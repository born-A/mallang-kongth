package capjjangdol.mallangkongth.service;

import capjjangdol.mallangkongth.domain.mypage.JoinForm;
import capjjangdol.mallangkongth.domain.mypage.LoginForm;
import capjjangdol.mallangkongth.domain.mypage.Member;
import capjjangdol.mallangkongth.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.transaction.Transactional;
import java.util.List;
@Slf4j
@Service
@Transactional
public class MemberService implements UserDetailsService{
//    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Autowired
    private MemberRepository memberRepository;

//    @Autowired
//    private Pet pet;

//    @Override
    /**
     * register
     */
    public Long join(JoinForm joinForm){
//        dto.encryptPassword(encoder.encode(dto.getPw()));
        Member member = joinForm.toEntity();
        memberRepository.save(member);
        log.info("db save successful");
        return member.getId();
    }
    /**
     * login
     */
    public Long login(LoginForm loginForm){
        Member member = loginForm.toEntity();
//        memberRepository

    }
    @Transactional
//    @Override
    public boolean checkEmailDuplication(String email) {
        boolean emailDuplicate = memberRepository.existsByEmail(email);
        return emailDuplicate;
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByEmail(member.getEmail());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("?? ???? ?????.");
        }
    }
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
