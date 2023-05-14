package capjjangdol.mallangkongth.RepositoryTest;

import capjjangdol.mallangkongth.domain.rearing.WaterBowl;
import capjjangdol.mallangkongth.repository.WaterBowlRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class WaterBowlRepositoryTest {
    @Autowired
    WaterBowlRepository waterBowlRepository;

    @Test
    public void waterBowlTest(){
        WaterBowl waterBowl = new WaterBowl();
        waterBowl.setSettingAmount(1);
        waterBowl.setRemaining(2);
        waterBowl.setBeforeEatingAmount(3);
        waterBowl.setCurrentEatingAmount(4);
        int waterAmount = waterBowlRepository.findRemaining();
        System.out.println(waterAmount);
    }

}
