package capjjangdol.mallangkongth.service;


import capjjangdol.mallangkongth.domain.rearing.WaterBowl;
import capjjangdol.mallangkongth.repository.WaterBowlRepository;
import capjjangdol.mallangkongth.repository.WaterNoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class WaterBowlService {
    @Autowired
    private WaterBowlRepository waterBowlRepository;

    @Autowired
    WaterNoteRepository waterNoteRepository;

    public void renewalWaterBowl(){
        int waterAmount = waterNoteRepository.findAmount().get(0);
        int settingAmount = waterBowlRepository.findSettingAmount().get(0);
        int beforeEatingAmount = waterBowlRepository.findBeforeEatingAmount().get(0);
        WaterBowl waterBowl = new WaterBowl();
        waterBowl.setSettingAmount(settingAmount);
        waterBowl.setRemaining(waterAmount);
        waterBowl.setBeforeEatingAmount(beforeEatingAmount);
        waterBowl.setCurrentEatingAmount(settingAmount - waterAmount + beforeEatingAmount);
        waterBowlRepository.save(waterBowl);
    }
}
