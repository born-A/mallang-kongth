package capjjangdol.mallangkongth.RepositoryTest;

import capjjangdol.mallangkongth.repository.MemberRepository;
import capjjangdol.mallangkongth.repository.domain.mypage.Address;
import capjjangdol.mallangkongth.repository.domain.mypage.Member;
import capjjangdol.mallangkongth.repository.domain.mypage.MemberAdapter;
import capjjangdol.mallangkongth.repository.domain.mypage.RoleType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
public class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;
    MemberAdapter memberAdapter;

    @Test
    @Transactional
    public void test() throws Exception{
        Member member = new Member();
        member.setName("member1");
        member.setEmail("sujin7187@kyonggi.ac.kr");
        member.setPw("test1234");
        member.setName("sujin");
        member.setAddress(new Address("suwon","aaaa","154-42"));
        member.setRoleType(RoleType.USER);
        Long saveId = memberRepository.save(member);
        Member findMember = memberRepository.findMember(member.getEmail()).get();
        Assertions.assertThat(findMember.getEmail()).isEqualTo(member.getEmail());
    }
}
