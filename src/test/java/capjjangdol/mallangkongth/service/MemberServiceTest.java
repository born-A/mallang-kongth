package capjjangdol.mallangkongth.service;

import capjjangdol.mallangkongth.domain.mypage.Address;
import capjjangdol.mallangkongth.domain.mypage.JoinForm;
import capjjangdol.mallangkongth.domain.mypage.Member;
import capjjangdol.mallangkongth.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static capjjangdol.mallangkongth.domain.mypage.RoleType.USER;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EntityManager em;

    @Test
//    @Rollback(value = false)
    public void memberJoinTest() throws Exception{
        //given
        JoinForm joinform = new JoinForm();
        joinform.setName("신짱구");
        joinform.setEmail("test@gmail.com");
        joinform.setAddress(new Address("suwon","gangkyosanro","1111"));
        joinform.setPw("test1234");
        joinform.setRoleType(USER);
        //when
        Long saveId = memberService.join(joinform);

        //then
        em.flush();
        Assertions.assertThat(memberRepository.existsByEmail("test@gmail.com"));
    }

    @Test(expected = IllegalStateException.class)
    public void nestedMemberTest() throws Exception {
        //given
        JoinForm joinForm = new JoinForm();
        joinForm.setEmail("test");

        JoinForm joinForm2 = new JoinForm();
        joinForm2.setEmail("test");
        //when
        memberService.join(joinForm);
        memberService.join(joinForm2); // exception


        //then
        Assert.fail("예외가 발생해야 한다.");
    }


}