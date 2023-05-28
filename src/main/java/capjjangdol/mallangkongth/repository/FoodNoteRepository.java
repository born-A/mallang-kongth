package capjjangdol.mallangkongth.repository;

import capjjangdol.mallangkongth.domain.rearing.FoodBowl;
import capjjangdol.mallangkongth.domain.rearing.FoodNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoodNoteRepository extends JpaRepository<FoodNote, Long> {
    @Query("SELECT fn.insertTime FROM FoodNote fn ORDER BY fn.id DESC")
    List<Integer> findInsertTime();
    @Query("SELECT fn.amount FROM FoodNote fn ORDER BY fn.id DESC")
    List<Integer> findAmount();
}
