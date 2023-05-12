package capjjangdol.mallangkongth.domain.rearing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RearingRepository extends JpaRepository<FoodBowl, Long> {
}