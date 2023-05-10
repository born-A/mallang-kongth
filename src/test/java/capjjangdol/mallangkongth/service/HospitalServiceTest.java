package capjjangdol.mallangkongth.service;

import capjjangdol.mallangkongth.domain.mypage.Pet;
import capjjangdol.mallangkongth.domain.rearing.HospitalNote;
import capjjangdol.mallangkongth.domain.rearing.HospitalNoteForm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import capjjangdol.mallangkongth.repository.HospitalRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class HospitalServiceTest {
    @PersistenceContext
    EntityManager em;
    @Autowired
    HospitalService hospitalService;
    @Autowired
    HospitalRepository hospitalRepository;
    @Test
    public void 병원기록등록() throws Exception {
        //Given
        Pet pet = new Pet();
        HospitalNoteForm form = new HospitalNoteForm();
        form.setHospitalName("test");
        form.setMemo("test");
        form.setImageUrl("test");

        em.persist(pet);
        //When
        Long hospitalNoteId = hospitalService.saveHospitalNote(pet.getId(), form);

        //Then
        HospitalNote getHospitalNote = hospitalRepository.findOne(hospitalNoteId);
    }

}