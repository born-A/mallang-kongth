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
    WaterLevelService waterLevelService;
    @Autowired
    WaterLevelRepository waterLevelRepository;

    @Autowired
    EntityManager em;

    @Test
    @Rollback(value = false)
    public void memberJoinTest() throws Exception {

        WaterLevel waterLevel = new WaterLevel();
        waterLevel.setWaterLevel(0);
        waterLevelRepository.save(waterLevel);
    }

}