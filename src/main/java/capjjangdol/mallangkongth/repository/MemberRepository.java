package capjjangdol.mallangkongth.repository;

import capjjangdol.mallangkongth.domain.mypage.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.naming.Name;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;

    public List<Member> findByUser_id(String user_id){
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    public boolean existsByUser_id(String user_id) {
        return false;
    }

    public Member findOne(Long id) {

        return em.find(Member.class, id);
    }
    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
    public List<Member> findAll() {

        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    public Long save(Member member){
        em.persist(member);
        return member.getId();
    }

}
