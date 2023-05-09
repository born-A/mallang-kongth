package capjjangdol.mallangkongth.domain.repository;

import capjjangdol.mallangkongth.domain.mypage.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.naming.Name;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByUser_id(String user_id);

    boolean existsByUser_id(String user_id);

//    public Long save(Member member){
//        em.persist(member);
//        return member.getId();
//    }

}
