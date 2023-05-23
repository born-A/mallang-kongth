package capjjangdol.mallangkongth.RepositoryTest;

import capjjangdol.mallangkongth.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

//@SpringBootTest
public class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

//    @Test
//    @Transactional
//    public void test() throws Exception{
//        Member member = new Member();
//        member.setName("member1");
//        member.setEmail("sujin7187@kyonggi.ac.kr");
//        member.setPw("test1234");
//        member.setName("sujin");
//        member.setAddress(new Address("suwon","aaaa","154-42"));
//        member.setRoleType(RoleType.USER);
//        Long saveId = memberRepository.save(member);
//        Member findMember = memberRepository.findMember(member.getEmail()).get();
//        Assertions.assertThat(findMember.getEmail()).isEqualTo(member.getEmail());
//    }
}
