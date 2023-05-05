package capjjangdol.mallangkongth.service;

import capjjangdol.mallangkongth.domain.feeder.WaterLevel;
import capjjangdol.mallangkongth.repository.WaterLevelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class WaterLevelService {

    private final WaterLevelRepository waterLevelRepository;
    @Transactional
    public Long create(WaterLevel waterLevel) {
        waterLevelRepository.save(waterLevel);

        return waterLevel.getId();
    }
}
