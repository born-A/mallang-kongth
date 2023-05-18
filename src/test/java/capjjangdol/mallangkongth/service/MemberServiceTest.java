package capjjangdol.mallangkongth.service;

import capjjangdol.mallangkongth.repository.domain.mypage.Address;
import capjjangdol.mallangkongth.repository.domain.mypage.Member;
import capjjangdol.mallangkongth.repository.domain.mypage.RoleType;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@SpringBootTest
@Transactional
public class MemberServiceTest {
    @Autowired
    MemberService memberService;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Test
    public Member createMember() {
        Address.SignUpForm memberSignUpRequesDto= Address.SignUpForm.builder()
                .email("test@email.com")
                .name("tester")
                .address(new Address("Suwon","GGG","154-42"))
                .pw("test1234")
                .roleType(RoleType.USER)
                .build();
        return Member.createMember(memberSignUpRequesDto,passwordEncoder);
    }

    @Test
    @DisplayName("회원가입 테스트")
    public void saveMemberTest() {
        Member member = Member.createMember();
        Long saveId = memberService.signUp(member.getId());
        assertEquals(member.getId(), saveId);
    }
//    @Test
//    public void login() {
//
//    }
}