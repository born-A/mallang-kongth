package capjjangdol.mallangkongth.repository;

import capjjangdol.mallangkongth.domain.mypage.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
//    private final EntityManager em;

    Optional<Member> findByEmail(String email);

    List<Member> findByUsername(String name);

    public boolean existsByEmail(String email);

//    public Member findOne(Long id) {
//
//        return em.find(Member.class, id);
//    }
//    public List<Member> findByName(String name) {
//        return em.createQuery("select m from Member m where m.name = :name", Member.class)
//                .setParameter("name", name)
//                .getResultList();
//    }
//    public List<Member> findAll() {
//
//        return em.createQuery("select m from Member m", Member.class).getResultList();
//    }
//
//    public Long save(Member member){
//        em.persist(member);
//        return member.getId();
//    }

}
