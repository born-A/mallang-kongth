//package capjjangdol.mallangkongth.service;
//
//import capjjangdol.mallangkongth.domain.mypage.Pet;
//import capjjangdol.mallangkongth.domain.rearing.Walking;
//import capjjangdol.mallangkongth.domain.rearing.WalkingForm;
//import capjjangdol.mallangkongth.repository.WalkingRepository;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.time.LocalDateTime;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Transactional
//public class WalkingServiceTest {
//    @PersistenceContext
//    EntityManager em;
//    @Autowired
//    WalkingService walkingService;
//    @Autowired
//    WalkingRepository walkingRepository;
//    @Test
//    public void 산책기록등록() throws Exception {
//        //Given
//        Pet pet = new Pet();
//        WalkingForm form = new WalkingForm();
//        form.setDateOfWalking(LocalDateTime.now());
//        em.persist(pet);
//        //When
//        Long walkingId = walkingService.saveWalking(pet.getId(), form);
//
//        //Then
//        Walking getWalking = walkingRepository.findOne(walkingId);
//        em.flush();
//        Assert.assertEquals(getWalking, walkingRepository.findOne(walkingId));
//    }
//}