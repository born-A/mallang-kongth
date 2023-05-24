package capjjangdol.mallangkongth.service;

import capjjangdol.mallangkongth.domain.mypage.Member;
import capjjangdol.mallangkongth.domain.mypage.Pet;
import capjjangdol.mallangkongth.domain.rearing.HospitalNote;
import capjjangdol.mallangkongth.domain.rearing.HospitalNoteForm;
import capjjangdol.mallangkongth.repository.HospitalRepository;
import capjjangdol.mallangkongth.repository.MemberRepository;
import capjjangdol.mallangkongth.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class HospitalService {
    private final PetRepository petRepository;
    private final HospitalRepository hospitalRepository;

    @Transactional
    public Integer saveHospitalNote(Long petId, HospitalNoteForm form) {
        //엔티티 조회
        Pet pet = petRepository.findOne(petId);
        HospitalNote hospitalNote = HospitalNote.createHospitalNote(pet,form);
        hospitalRepository.save(hospitalNote);
        return hospitalNote.getId();
    }
    public List<HospitalNote> findHospitalNotes() {
        return hospitalRepository.findAll();
    }
    public HospitalNote findOne(Integer hospitalNoteId) {
        return hospitalRepository.findById(hospitalNoteId).get();
    }

    @Transactional
    public void deleteById(Integer hospitalNoteId){
        hospitalRepository.deleteById(hospitalNoteId);
    }

    public HospitalNote hospitalNotesView(Integer id){
        return hospitalRepository.findById(id).get();
    }
}
