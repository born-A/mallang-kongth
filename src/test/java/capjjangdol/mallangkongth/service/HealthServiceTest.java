package capjjangdol.mallangkongth.service;

import capjjangdol.mallangkongth.domain.mypage.Pet;
import capjjangdol.mallangkongth.domain.rearing.Health;
import capjjangdol.mallangkongth.repository.domain.rearing.HealthForm;
import capjjangdol.mallangkongth.domain.rearing.HospitalNote;
import capjjangdol.mallangkongth.domain.rearing.HospitalNoteForm;
import capjjangdol.mallangkongth.repository.HealthRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class HealthServiceTest {
    @PersistenceContext
    EntityManager em;
    @Autowired
    HealthService healthService;
    @Autowired
    HealthRepository healthRepository;
    @Test
    public void 건강기록등록() throws Exception {
        //Given
        Pet pet = new Pet();
        HealthForm form = new HealthForm();
        form.setText("test");
        form.setImageUrl("test");

        em.persist(pet);
        //When
        Long healthId = healthService.saveHealth(pet.getId(), form);

        //Then
        Health getHealth = healthRepository.findOne(healthId);
        em.flush();
        Assert.assertEquals(getHealth, healthRepository.findOne(healthId));
    }
}