package capjjangdol.mallangkongth.repository;

//import capjjangdol.mallangkongth.domain.rearing.Health;
//import capjjangdol.mallangkongth.domain.rearing.HospitalNote;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.EntityManager;
//import java.util.List;
//
//@Repository
//@RequiredArgsConstructor
//public class HospitalRepository {
//    private final EntityManager em;
//    public void save(HospitalNote hospitalNote) {
//
//        em.persist(hospitalNote);
//    }
//    public HospitalNote findOne(Long id) {
//        return em.find(HospitalNote.class, id);
//    }
//
//
//    public List<HospitalNote> findAll() {
//        return em.createQuery("select h from HospitalNote h",HospitalNote.class).getResultList();
//    }
//
//    /**
//     * 건강기록 삭제
//     */
////    @Modifying
////    @Transactional
////    @Query("DELETE FROM HospitalNote h where h.id =: id")
////    public void deleteById(@Param("id") Long id) {
////
////    }
//
//    @Modifying
//    public void deleteById(Long id) {
//        em.createQuery("delete from HospitalNote h where h.id =: id")
//                .setParameter("id", id);
//    }
//
//
//}
//

import capjjangdol.mallangkongth.domain.mypage.Member;
import capjjangdol.mallangkongth.domain.mypage.Pet;
import capjjangdol.mallangkongth.domain.rearing.HospitalNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<HospitalNote, Integer> {
    List<HospitalNote> findByMember(Member member);
}