package capjjangdol.mallangkongth.repository;

import capjjangdol.mallangkongth.domain.rearing.FoodServingTime;
import capjjangdol.mallangkongth.dto.FoodServingTimeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface FoodServingTimeRepository extends JpaRepository<FoodServingTime, Long> {
    @Query("SELECT new capjjangdol.mallangkongth.dto.FoodServingTimeDto(fst.id,fst.servingTime, fst.servingSize) FROM FoodServingTime fst ORDER BY fst.id DESC")
    List<FoodServingTimeDto> findFoodServingTime();

    @Query("SELECT fst.servingSize FROM FoodServingTime fst ORDER BY fst.id DESC")
    List<Integer> findServingSize();

}
