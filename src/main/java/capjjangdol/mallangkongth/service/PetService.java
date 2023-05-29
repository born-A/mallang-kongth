package capjjangdol.mallangkongth.service;

import capjjangdol.mallangkongth.domain.mypage.Pet;
import capjjangdol.mallangkongth.domain.mypage.PetForm;
import capjjangdol.mallangkongth.domain.rearing.Walking;
import capjjangdol.mallangkongth.domain.rearing.WalkingForm;
import capjjangdol.mallangkongth.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;

//    @Transactional
//    public Long create(Pet pet) {
//        petRepository.save(pet);
//
//        return pet.getId();
//    }

    @Transactional
    public Long savePet(Long petId, PetForm form) {
        //엔티티 조회
        Pet pet = petRepository.findById(petId).get();
        petRepository.save(pet);
        return pet.getId();
    }

    @Transactional
    public void savePet(Pet pet) {
        petRepository.save(pet);
    }


    public List<Pet> findPets() {
        return petRepository.findAll();
    }

    public Pet findOne(Long memberId) {
        return petRepository.findById(memberId).get();
    }

    public Pet petView(Long id){
        return petRepository.findById(id).get();
    }
    @Transactional
    public void deleteById(Long petId){
        petRepository.deleteById(petId);
    }
}
