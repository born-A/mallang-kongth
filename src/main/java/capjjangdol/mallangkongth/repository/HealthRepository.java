package capjjangdol.mallangkongth.repository;

import capjjangdol.mallangkongth.domain.rearing.Health;
import capjjangdol.mallangkongth.domain.rearing.HospitalNote;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class HealthRepository {
    private final EntityManager em;
    public void save(Health health) {

        em.persist(health);
    }
    public Health findOne(Long id) {
        return em.find(Health.class, id);
    }


    public List<Health> findAll() {
        return em.createQuery("select h from Health h",Health.class).getResultList();
    }

    /**
     * 건강기록 삭제
     */
    public List<Health> deleteById(Long id){
        return em.createQuery("delete from Health h where h.id =: id", Health.class).getResultList();
    }
}

