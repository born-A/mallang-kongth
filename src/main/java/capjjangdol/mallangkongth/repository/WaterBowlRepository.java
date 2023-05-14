package capjjangdol.mallangkongth.repository;

import capjjangdol.mallangkongth.domain.rearing.WaterBowl;
import capjjangdol.mallangkongth.domain.rearing.WaterNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface WaterBowlRepository extends JpaRepository<WaterBowl, Long> {
    @Query("SELECT wb.settingAmount FROM WaterBowl wb ORDER BY wb.id DESC")
    List<Integer> findSettingAmount();

    @Query("SELECT wb.beforeEatingAmount FROM WaterBowl wb ORDER BY wb.id DESC")
    List<Integer> findBeforeEatingAmount();

    @Query("SELECT wb.currentEatingAmount FROM WaterBowl wb ORDER BY wb.id DESC")
    List<Integer> findCurrentEatingAmount();

    @Query("SELECT wb.remaining FROM WaterBowl wb ORDER BY wb.id DESC")
    List<Integer> findRemaining();
}
