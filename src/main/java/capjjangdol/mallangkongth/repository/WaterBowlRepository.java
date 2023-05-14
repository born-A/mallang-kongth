package capjjangdol.mallangkongth.repository;

import capjjangdol.mallangkongth.domain.rearing.WaterBowl;
import capjjangdol.mallangkongth.domain.rearing.WaterNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WaterBowlRepository extends JpaRepository<WaterBowl, String> {
    @Query(value = "SELECT setting_amount FROM water_bowl WHERE id = (SELECT MAX(id) FROM water_bowl )")
    Integer findSettingAmount();
    @Query(value = "SELECT before_eating_amount FROM water_bowl WHERE id = (SELECT MAX(id) FROM water_bowl )")
    Integer findBeforeEatingAmount();

    @Query(value = "SELECT current_eating_amount FROM water_bowl WHERE id = (SELECT MAX(id) FROM water_bowl )")
    Integer findCurrentEatingAmount();
    @Query(value = "SELECT remaining FROM water_bowl WHERE id = (SELECT MAX(id) FROM water_bowl )")
    Integer findremaining();
}
