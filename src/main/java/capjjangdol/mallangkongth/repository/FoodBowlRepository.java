package capjjangdol.mallangkongth.repository;

import capjjangdol.mallangkongth.domain.rearing.FoodBowl;
import capjjangdol.mallangkongth.domain.rearing.FoodBowl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoodBowlRepository extends JpaRepository<FoodBowl, Long> {
    @Query("SELECT fb.settingAmount FROM FoodBowl fb ORDER BY fb.id DESC")
    List<Integer> findSettingAmount();

    @Query("SELECT fb.beforeEatingAmount FROM FoodBowl fb ORDER BY fb.id DESC")
    List<Integer> findBeforeEatingAmount();

    @Query("SELECT fb.currentEatingAmount FROM FoodBowl fb ORDER BY fb.id DESC")
    List<Integer> findCurrentEatingAmount();

    @Query("SELECT fb.remaining FROM FoodBowl fb ORDER BY fb.id DESC")
    List<Integer> findRemaining();
}
