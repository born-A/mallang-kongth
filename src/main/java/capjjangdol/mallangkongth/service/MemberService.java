package capjjangdol.mallangkongth.service;

import capjjangdol.mallangkongth.config.SecurityUtil;
import capjjangdol.mallangkongth.domain.mypage.Member;
import capjjangdol.mallangkongth.domain.mypage.MemberResDto;
import capjjangdol.mallangkongth.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    //헤더 토큰값 전달 메소드
    public Member getMyInfoBySecurity(){
        Member member = memberRepository.findById(SecurityUtil.getCurrentMemberId()).orElseThrow(()->new RuntimeException("로그인 유저 정보가 없습니다"));
                return;
    }
    //이름 변경
    @Transactional
    public Member changeMembername(String email, String name){
        Member member = memberRepository.findByEmail(email);
//        try {
//            catch(RuntimeException e)
//            new RuntimeException("로그인 유저 정보가 없습니다");
//        }
        member.setName(name);
        return memberRepository.save(member);
    }
    //pw 변경
    @Transactional
    public Member changeMemberPw(String exPw, String newPw) {
        Member member = memberRepository.findById(SecurityUtil.getCurrentMemberId()).orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다"));
        if (!passwordEncoder.matches(exPw, member.getPw())) {
            throw new RuntimeException("비밀번호가 맞지 않습니다");
        }
        member.setPw(passwordEncoder.encode((newPw)));
        return memberRepository.save(member);
    }
}