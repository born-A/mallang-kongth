package capjjangdol.mallangkongth.repository;

import capjjangdol.mallangkongth.domain.feeder.WaterLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class WaterLevelRepository {
    private final EntityManager em;
    public void save(WaterLevel waterLevel) {
        em.persist(waterLevel);
    }

    public WaterLevel findOne(Long id) {
        return em.find(WaterLevel.class, id);
    }

}
