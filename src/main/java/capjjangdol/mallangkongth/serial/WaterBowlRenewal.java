package capjjangdol.mallangkongth.serial;

import capjjangdol.mallangkongth.domain.rearing.WaterBowl;
import capjjangdol.mallangkongth.repository.WaterNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WaterBowlRenewal {

    @Autowired
    WaterNoteRepository waterNoteRepository;

    @Scheduled(cron = "0 0 0 * * *") // 매일 0시에 실행
    public void myTask() {
        int waterAmount = waterNoteRepository.findWaterAmountLatestInsertTime();
        WaterBowl waterBowl = new WaterBowl();
        waterBowl.setSettingAmount(waterAmount);
        waterBowl.setRemaining(waterAmount);
        waterBowl.setBeforeEatingAmount(0);
        waterBowl.setCurrentEatingAmount(0);
    }
}


