package capjjangdol.mallangkongth.ArduinoTest;

import capjjangdol.mallangkongth.domain.feeder.WaterLevel;
import capjjangdol.mallangkongth.repository.WaterLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/*
 // 콘솔 실행용 코드
public class WaterData {
    int num;

    public WaterData(int num)
    {
        this.num = num;
        Print();
    }

    public void Print()
    {
        System.out.println("WaterData : "+num);
    }
}
*/

@Component
public class WaterData {

    @Autowired
    WaterLevelRepository waterLevelRepository;

    public void saveWater(WaterLevel waterLevel)
    {
        waterLevelRepository.save(waterLevel);
    }
}