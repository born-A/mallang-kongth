package capjjangdol.mallangkongth.domain.rearing;

import capjjangdol.mallangkongth.domain.rearing.FoodBowl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RearingRepository extends JpaRepository<FoodBowl, Long> {
}