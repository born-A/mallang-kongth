package capjjangdol.mallangkongth.RepositoryTest;

import capjjangdol.mallangkongth.domain.rearing.WaterNote;
import capjjangdol.mallangkongth.repository.WaterNoteRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class WaterNoteRepositoryTest {

    @Autowired
    private WaterNoteRepository waterNoteRepository;

    @Autowired
    EntityManager em;

    @Test
    public void saveWaterNoteTest() {
        // 새로운 WaterNote 객체 생성
        WaterNote waterNote = new WaterNote();
        waterNote.setAmount(50);

        // WaterNote 객체 저장
        WaterNote savedWaterNote = waterNoteRepository.save(waterNote);
        em.flush();
    }
}