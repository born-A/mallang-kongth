package capjjangdol.mallangkongth.service;

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

import capjjangdol.mallangkongth.domain.mypage.Member;
import capjjangdol.mallangkongth.domain.mypage.MemberDto;
import capjjangdol.mallangkongth.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@EnableCaching
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원가입
     */
    @Transactional
    public Long join(Member member){
        validateDuplicateMember(member.getEmail()); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    // 회원 전체 조회
    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId){
        return memberRepository.findById(memberId).get();
    }

    private void validateDuplicateMember(String email) {
        //EXCEPTION
        Optional<Member> findMember = memberRepository.findByEmail(email);
        if(findMember.isPresent()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    @Transactional
    public void update(Long id, String name) {
        Member member = memberRepository.findById(id).get();
        validateDuplicateMember(name);
        member.changeName(name);
    }

    public List<Member> findByName(String name){
        return memberRepository.findByUsername(name);
    }

    /**
     * 페이징
     **/
    @Cacheable("members")
    public Page<MemberDto> findAll(Pageable pageable){
        return memberRepository.findAll(pageable).map(m -> new MemberDto(m));
    }


    @Transactional
    public void updateMember(Long id, String email, String password, String username, String city, String street, String zipcode, HttpServletRequest request) {
        Optional<Member> findMember = memberRepository.findById(id);
        Member member = findMember.orElseThrow(() -> new IllegalStateException("해당하는 멤버가 존재하지 않습니다."));
        member.update(email,password,username,city,street,zipcode);
    }

    @Transactional
    public void deleteById(Long memberId){
        memberRepository.deleteById(memberId);
    }
}