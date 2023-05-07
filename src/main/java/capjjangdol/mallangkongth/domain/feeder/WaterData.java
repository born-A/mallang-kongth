package capjjangdol.mallangkongth.domain.feeder;


import capjjangdol.mallangkongth.repository.WaterLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class WaterData {

    @Autowired
    WaterLevelRepository waterLevelRepository;


    public void saveWater(WaterLevel waterLevel)
    {
        waterLevelRepository.save(waterLevel);
    }
}