package capjjangdol.mallangkongth.repository;

import capjjangdol.mallangkongth.repository.domain.mypage.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;
    //email로 회원 찾기
    public Optional<Member> findByEmail(String email){
        Optional<Member> member = null;
        try{
            member =Optional.ofNullable(em.createQuery("select m from Member m where m.email = :email", Member.class).setParameter("email",email).getSingleResult());
        }catch (NoResultException e) {
        member = Optional.empty();
        }finally {
            return member;
        }
    }

    public boolean existsByEmail(String email) {
        return false;
    }
    //member id로 회원 찾기
    public Member findOne(Long id) {

        return em.find(Member.class, id);
    }

    public Optional<Member> findAll() {
        Optional<Member> member = null;
        try{
            member =Optional.ofNullable(em.createQuery("select m from Member m", Member.class).getSingleResult());
        }catch (NoResultException e) {
            member = Optional.empty();
        }finally {
            return member;
        }
    }
    public Optional<Member> findMember(String name){
        Optional<Member> member= null;
        try{
            member =Optional.ofNullable(em.createQuery("select m from Member m where m.name = :name", Member.class).setParameter("name",name).getSingleResult());
        }catch (NoResultException e) {
            member = Optional.empty();
        }finally {
            return member;
        }
    }
    public Long save(Member member){
        em.persist(member);
        return member.getId();
    }

}
