package capjjangdol.mallangkongth.service;

import capjjangdol.mallangkongth.domain.feeder.WaterLevel;
import capjjangdol.mallangkongth.repository.WaterLevelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class WaterLevelService {

    private final WaterLevelRepository waterLevelRepository;

    public void saveWaterLevel(int waterLevel) {
        WaterLevel newWaterLevel = new WaterLevel();
        newWaterLevel.setWaterLevel(waterLevel);
        waterLevelRepository.save(newWaterLevel);
    }
}
