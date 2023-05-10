package capjjangdol.mallangkongth.service;

/**import capjjangdol.mallangkongth.domain.mypage.Member;
import capjjangdol.mallangkongth.repository.MemberRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

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
    @Rollback(value = false)
    public void memberJoinTest() throws Exception{
        //given
        Member member = new Member();
        member.setName("신짱구");

        //when
        Long saveId = memberService.join(member);

        //then
        em.flush();
        Assert.assertEquals(member, memberRepository.findOne(saveId));
    }

    @Test(expected = IllegalStateException.class)
    public void nestedMemberTest() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("shin1");

        Member member2 = new Member();
        member2.setName("shin1");
        //when
        memberService.join(member1);
        memberService.join(member2); // exception


        //then
        Assert.fail("예외가 발생해야 한다.");
    }


}
 **/