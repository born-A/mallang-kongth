package capjjangdol.mallangkongth.service;

import capjjangdol.mallangkongth.domain.mypage.Member;
import capjjangdol.mallangkongth.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    public Long login(String email, String password) {
        Member findMember = memberRepository.findByEmail(email).orElseThrow( ()->
                new IllegalStateException("LoginService : login → email과 password가 일치하지 않습니다."));

        if(!findMember.checkPassword(password)){
            throw new IllegalStateException("이메일과 비밀번호가 일치하지 않습니다.");
        }

        return findMember.getId();
    }

}