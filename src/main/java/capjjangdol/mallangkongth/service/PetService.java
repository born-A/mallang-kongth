package capjjangdol.mallangkongth.service;

import capjjangdol.mallangkongth.domain.mypage.Pet;
import capjjangdol.mallangkongth.repository.PetRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;

    @Transactional
    public Long create(Pet pet) {
        petRepository.save(pet);

        return pet.getId();
    }


    public List<Pet> findPets() {
        return petRepository.findAll();
    }

    public Pet findOne(Long memberId) {
        return petRepository.findOne(memberId);
    }
}
