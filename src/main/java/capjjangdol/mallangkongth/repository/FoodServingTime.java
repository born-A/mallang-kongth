package capjjangdol.mallangkongth.repository;

import capjjangdol.mallangkongth.dto.FoodServingTimeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface FoodServingTime extends JpaRepository<FoodServingTime, Long> {
    @Query("SELECT new capjjangdol.mallangkongth.dto.FoodServingTimeDto(fst.id,fst.servingTime, fst.servingSize) FROM FoodServingTime fst ORDER BY fst.id DESC")
    List<FoodServingTimeDto> findFoodServingTime();

}
