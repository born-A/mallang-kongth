package capjjangdol.mallangkongth.domain.feeder;


import capjjangdol.mallangkongth.repository.WaterLevelRepository;

public class WaterData {
    WaterLevelRepository waterLevelRepository;

    public WaterData(WaterLevel waterLevel)
    {
        waterLevelRepository.save(waterLevel);
    }
}