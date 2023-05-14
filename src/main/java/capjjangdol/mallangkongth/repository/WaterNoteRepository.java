package capjjangdol.mallangkongth.repository;

import capjjangdol.mallangkongth.domain.rearing.WaterNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterNoteRepository extends JpaRepository<WaterNote, Long> {
    //가장 마지막에 입력된 수위센서 값
    @Query(value = "SELECT w1.insertTime FROM WaterNote w1 WHERE w1.id = (SELECT MAX(w2.id) FROM WaterNote w2 )")
    Integer findWaterAmountLatestInsertTime();
}