package capjjangdol.mallangkongth.repository;

import capjjangdol.mallangkongth.domain.rearing.WaterBowl;
import capjjangdol.mallangkongth.domain.rearing.WaterNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WaterBowlRepository extends JpaRepository<WaterBowl, String> {
    @Query("SELECT wb.settingAmount FROM WaterBowl wb ORDER BY wb.id DESC")
    Integer findSettingAmount();
    @Query("SELECT wb.beforeEatingAmount FROM WaterBowl wb ORDER BY wb.id DESC")
    Integer findBeforeEatingAmount();
    @Query("SELECT wb.currentEatingAmount FROM WaterBowl wb ORDER BY wb.id DESC")
    Integer findCurrentEatingAmount();
    @Query("SELECT wb.remaining FROM WaterBowl wb ORDER BY wb.id DESC")
    Integer findRemaining();
}
