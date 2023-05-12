package capjjangdol.mallangkongth.service;

import capjjangdol.mallangkongth.domain.mypage.Member;
import capjjangdol.mallangkongth.domain.mypage.Pet;
import capjjangdol.mallangkongth.domain.rearing.Health;
import capjjangdol.mallangkongth.repository.domain.rearing.HealthForm;
import capjjangdol.mallangkongth.domain.rearing.HospitalNote;
import capjjangdol.mallangkongth.domain.rearing.HospitalNoteForm;
import capjjangdol.mallangkongth.repository.HealthRepository;
import capjjangdol.mallangkongth.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class HealthService {
    private final PetRepository petRepository;
    private final HealthRepository healthRepository;

    @Transactional
    public Long saveHealth(Long petId, HealthForm form) {
        //엔티티 조회
        Pet pet = petRepository.findOne(petId);
        Health health = Health.createHealth(pet,form);
        healthRepository.save(health);
        return health.getId();
    }
    public List<Health> findHealths() {
        return healthRepository.findAll();
    }
    public Health findOne(Long healthId) {
        return healthRepository.findOne(healthId);
    }

}
