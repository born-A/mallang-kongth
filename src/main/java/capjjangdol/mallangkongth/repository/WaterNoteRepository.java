package capjjangdol.mallangkongth.repository;


import capjjangdol.mallangkongth.domain.rearing.WaterNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface WaterNoteRepository extends JpaRepository<WaterNote, Long> {
    //가장 마지막에 입력된 수위센서 값

    @Query("SELECT wn.insertTime FROM WaterNote wn ORDER BY wn.id DESC")
    List<Integer> findInsertTime();
    @Query("SELECT wn.amount FROM WaterNote wn ORDER BY wn.id DESC")
    List<Integer> findAmount();
}