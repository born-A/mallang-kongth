package capjjangdol.mallangkongth.service;

import capjjangdol.mallangkongth.domain.mypage.Member;
import capjjangdol.mallangkongth.domain.mypage.Pet;
import capjjangdol.mallangkongth.domain.rearing.Health;
import capjjangdol.mallangkongth.domain.rearing.HealthForm;
import capjjangdol.mallangkongth.domain.rearing.HospitalNote;
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
        Pet pet = petRepository.findById(petId).get();
        Health health = Health.createHealth(pet,form);
        healthRepository.save(health);
        return health.getId();
    }

    @Transactional
    public void saveHealth(Health health) {
        healthRepository.save(health);
    }
    public List<Health> findHealths() {
        return healthRepository.findAll();
    }
    public List<Health> findHealths(Member member) {
        return healthRepository.findByMember(member);
    }

    public Health findOne(Long healthId) {
        return healthRepository.findById(healthId).get();
    }
    public Health healthView(Long id){
        return healthRepository.findById(id).get();
    }
    @Transactional
    public void deleteById(Long healthId){
        healthRepository.deleteById(healthId);
    }
}
