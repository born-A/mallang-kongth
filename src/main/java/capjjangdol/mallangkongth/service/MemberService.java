//package capjjangdol.mallangkongth.service;
//
//import capjjangdol.mallangkongth.config.SecurityUtil;
//import capjjangdol.mallangkongth.domain.mypage.MemberResDto;
//import capjjangdol.mallangkongth.jwt.TokenDto;
//import capjjangdol.mallangkongth.jwt.TokenProvider;
//import capjjangdol.mallangkongth.domain.mypage.Member;
//import capjjangdol.mallangkongth.repository.MemberRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//@Slf4j
//@Service
//@RequiredArgsConstructor
//@Transactional(readOnly = true)
//public class MemberService {
//    private final MemberRepository memberRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    //헤더 토큰값 전달 메소드
//    public MemberResDto getMyInfoBySecurity() {
//        return memberRepository.findById(SecurityUtil.getCurrentMemberId())
//                .map(MemberResDto::of)
//                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다"));
//    }
//    //이름 변경
//    @Transactional
//    public MemberResDto changeMembername(String email, String name) {
//        Member member = memberRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다"));
//        member.setName(name);
//        return MemberResDto.of(memberRepository.save(member));
//    }
//    //pw 변경
//    @Transactional
//    public MemberResDto changeMemberPw(String exPw, String newPw) {
//        Member member = memberRepository.findById(SecurityUtil.getCurrentMemberId()).orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다"));
//        if (!passwordEncoder.matches(exPw, member.getPw())) {
//            throw new RuntimeException("비밀번호가 맞지 않습니다");
//        }
//        member.setPw(passwordEncoder.encode((newPw)));
//        return MemberResDto.of(memberRepository.save(member));
//    }
//}