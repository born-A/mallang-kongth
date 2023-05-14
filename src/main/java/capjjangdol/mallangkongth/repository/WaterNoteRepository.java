package capjjangdol.mallangkongth.repository;

import capjjangdol.mallangkongth.domain.rearing.WaterNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterNoteRepository extends JpaRepository<WaterNote, Long> {
    //가장 마지막에 입력된 수위센서 값
    @Query(value = "SELECT water_amount FROM water_note WHERE insert_time = (SELECT MAX(insert_time) FROM water_note )")
    Integer findWaterAmountLatestInsertTime();
}