package capjjangdol.mallangkongth.repository;

import capjjangdol.mallangkongth.domain.feeder.WaterLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public interface WaterLevelRepository extends JpaRepository<WaterLevel, Long> {

}
