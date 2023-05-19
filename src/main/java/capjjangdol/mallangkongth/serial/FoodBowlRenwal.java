package capjjangdol.mallangkongth.serial;

import capjjangdol.mallangkongth.domain.rearing.WaterBowl;
import capjjangdol.mallangkongth.repository.WaterBowlRepository;
import capjjangdol.mallangkongth.repository.WaterNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FoodBowlRenwal {
    @Autowired
    WaterNoteRepository foodNoteRepository;

    @Autowired
    WaterBowlRepository foodBowlRepository;

    @Scheduled(cron = "0 0 0 * * *") // 매일 0시에 급식량 초기화
    public void eatingAmountReset() {
        int foodAmount = foodNoteRepository.findAmount().get(0);
        WaterBowl foodBowl = new WaterBowl();
        //요소 set 하는 코드 추가 해야함
        foodBowlRepository.save(foodBowl);
    }
    
}
