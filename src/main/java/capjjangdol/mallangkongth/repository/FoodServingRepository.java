package capjjangdol.mallangkongth.repository;

import capjjangdol.mallangkongth.domain.rearing.FoodServing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface FoodServingRepository extends JpaRepository<FoodServing, Long> {
    @Query("SELECT fs.foodServingSize FROM FoodServing fs ORDER BY fs.id DESC")
    List<Integer> findFoodServingSize();

    @Query("SELECT fs.insertTime FROM FoodServing fs ORDER BY fs.insertTime DESC")
    List<LocalDateTime> findInsertTime();

}
