package capjjangdol.mallangkongth.repository;

import capjjangdol.mallangkongth.domain.rearing.WaterNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterNoteRepository extends JpaRepository<WaterNote, Long> {
    //가장 마지막에 입력된 수위센서 값
    @Query("SELECT wb.insertTime FROM WaterNote wb ORDER BY wb.id DESC")
    Integer findWaterAmountLatestInsertTime();
}