package capjjangdol.mallangkongth.repository;

import capjjangdol.mallangkongth.domain.rearing.Health;
import capjjangdol.mallangkongth.domain.rearing.Walking;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class WalkingRepository {
    private final EntityManager em;
    public void save(Walking walking) {

        em.persist(walking);
    }
    public Walking findOne(Long id) {
        return em.find(Walking.class, id);
    }


    public List<Walking> findAll() {
        return em.createQuery("select w from Walking w",Walking.class).getResultList();
    }

    public List<Walking> findAllOfDay(LocalDateTime dateTime){
        return em.createQuery("select w from Walking w where w.dateOfWalking =: datetime group by w.dateOfWalking", Walking.class)
                .setParameter("datetime", dateTime)
                .getResultList();
    }
}