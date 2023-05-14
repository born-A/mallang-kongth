package capjjangdol.mallangkongth.repository;

import capjjangdol.mallangkongth.domain.rearing.WaterBowl;
import capjjangdol.mallangkongth.domain.rearing.WaterNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WaterBowlRepository extends JpaRepository<WaterBowl, String> {
    @Query(value = "SELECT w1.settingAmount FROM WaterBowl w1 WHERE w1.id = (SELECT MAX(w2.id) FROM WaterBowl w2 )")
    Integer findSettingAmount();
    @Query(value = "SELECT w1.beforeEatingAmount FROM WaterBowl w1 WHERE w1.id = (SELECT MAX(w2.id) FROM WaterBowl w2 )")
    Integer findBeforeEatingAmount();
    @Query(value = "SELECT w1.currentEatingAmount FROM WaterBowl w1 WHERE w1.id = (SELECT MAX(w2.id) FROM WaterBowl w2 )")
    Integer findCurrentEatingAmount();
    @Query(value = "SELECT w1.remaining FROM WaterBowl w1 WHERE w1.id = (SELECT MAX(w2.id) FROM WaterBowl w2 )")
    Integer findremaining();
}
