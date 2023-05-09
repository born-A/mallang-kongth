package capjjangdol.mallangkongth.service;

import capjjangdol.mallangkongth.domain.feeder.WaterLevel;
import capjjangdol.mallangkongth.domain.mypage.Member;
import capjjangdol.mallangkongth.repository.MemberRepository;
import capjjangdol.mallangkongth.repository.WaterLevelRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class WaterLevelTest {

    @Autowired
    private WaterLevelRepository waterLevelRepository;

    @Test
    public void saveWaterLevelTest() {
        // 새로운 WaterLevel 객체 생성
        WaterLevel waterLevel = new WaterLevel();
        waterLevel.setWaterLevel(50);

        // WaterLevel 객체 저장
        WaterLevel savedWaterLevel = waterLevelRepository.save(waterLevel);
    }
}
