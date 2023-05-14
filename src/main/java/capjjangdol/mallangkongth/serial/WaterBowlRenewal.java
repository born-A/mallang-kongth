package capjjangdol.mallangkongth.serial;

import capjjangdol.mallangkongth.domain.rearing.WaterBowl;
import capjjangdol.mallangkongth.repository.WaterBowlRepository;
import capjjangdol.mallangkongth.repository.WaterNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class WaterBowlRenewal {

    @Autowired
    WaterNoteRepository waterNoteRepository;

    @Autowired
    WaterBowlRepository waterBowlRepository;

    @Scheduled(cron = "0 0 0 * * *") // 매일 0시에 음수량 초기화
    public void eatingAmountReset() {
        int waterAmount = waterNoteRepository.findWaterAmountLatestInsertTime();
        WaterBowl waterBowl = new WaterBowl();
        waterBowl.setSettingAmount(waterAmount);
        waterBowl.setRemaining(waterAmount);
        waterBowl.setBeforeEatingAmount(0);
        waterBowl.setCurrentEatingAmount(0);
        waterBowlRepository.save(waterBowl);
    }

    @Scheduled(fixedDelay = 30000)  //30초에 한번씩 잔여량과 음수량 갱신
    public void eatingAmountRenewal(){
        int waterAmount = waterNoteRepository.findWaterAmountLatestInsertTime();
        int settingAmount = waterBowlRepository.findLatestSettingAmount();
        int beforeEatingAmount = waterBowlRepository.findLatestBeforeEatingAmount();
        WaterBowl waterBowl = new WaterBowl();
        waterBowl.setSettingAmount(settingAmount);
        waterBowl.setRemaining(waterAmount);
        waterBowl.setBeforeEatingAmount(beforeEatingAmount);
        waterBowl.setCurrentEatingAmount(settingAmount - waterAmount + beforeEatingAmount);
        waterBowlRepository.save(waterBowl);
    }
}


