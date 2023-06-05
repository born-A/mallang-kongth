package capjjangdol.mallangkongth.repository;

//import capjjangdol.mallangkongth.domain.rearing.Health;
//import capjjangdol.mallangkongth.domain.rearing.Walking;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Repository
//@RequiredArgsConstructor
//public class WalkingRepository {
//    private final EntityManager em;
//    public void save(Walking walking) {
//
//        em.persist(walking);
//    }
//    public Walking findOne(Long id) {
//        return em.find(Walking.class, id);
//    }
//
//
//    public List<Walking> findAll() {
//        return em.createQuery("select w from Walking w",Walking.class).getResultList();
//    }
//
//    public List<Walking> findAllOfDay(LocalDateTime dateTime){
//        return em.createQuery("select w from Walking w where w.dateOfWalking =: datetime group by w.dateOfWalking", Walking.class)
//                .setParameter("datetime", dateTime)
//                .getResultList();
//    }
//
//    /**
//     *  삭제
//     */
//    public List<Walking> deleteById(Long id){
//        return em.createQuery("delete from Walking w where w.id =: id", Walking.class).getResultList();
//    }
//}

import capjjangdol.mallangkongth.domain.mypage.Member;
import capjjangdol.mallangkongth.domain.mypage.Pet;
import capjjangdol.mallangkongth.domain.rearing.Walking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface WalkingRepository extends JpaRepository<Walking, Long> {
//    Long countBy();
//
    List<Walking> findByDateOfWalking(String date);

    List<Walking> findByPet(Pet pet);


    Long countByDateOfWalking(String date);
}