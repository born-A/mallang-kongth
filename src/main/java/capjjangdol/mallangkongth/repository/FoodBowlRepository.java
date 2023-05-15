package capjjangdol.mallangkongth.repository;

import capjjangdol.mallangkongth.domain.rearing.FoodBowl;
import capjjangdol.mallangkongth.domain.rearing.WaterBowl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodBowlRepository extends JpaRepository<FoodBowl, Long> {
}
