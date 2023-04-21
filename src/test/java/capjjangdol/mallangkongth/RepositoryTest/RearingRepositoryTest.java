package capjjangdol.mallangkongth.RepositoryTest;

import capjjangdol.mallangkongth.MallangKongthApplicationTests;
import capjjangdol.mallangkongth.domain.community.board.Board;
import capjjangdol.mallangkongth.domain.rearing.FoodBowl;
import capjjangdol.mallangkongth.domain.rearing.RearingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@DataJpaTest
@SpringBootTest
public class RearingRepositoryTest extends MallangKongthApplicationTests {
    @Autowired
    RearingRepository rearingRepository;

    @Test
    void save(){
        FoodBowl params = FoodBowl.builder().
    }
//        FoodBowl foodbowl1 = new FoodBowl();
//        foodbowl1.setRemaining(Long.valueOf(100));
//        foodbowl1.setSettingAmount(Long.valueOf(20));
//        foodbowl1.getEatingAmount();
//        RearingRepository.save(foodbowl1);
//    }
//    @Test
//    public void FoodNoteTest(){
//
//    }
//    @Test
//    public void WaterBowlTest(){
//
//    }
//    @Test
//    public void WaterNoteTest(){
//
//    }
//
//    @Test
//    public void HealthTest(){
//
//    }
//    @Test
//    public void HospitalNoteTest(){
//
//    }
//    @Test
//    public void Ingredient(){
//
//    }

}
