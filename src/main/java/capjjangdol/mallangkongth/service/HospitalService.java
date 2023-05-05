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

    /** 주문 */
    @Transactional
    public Long saveHospitalNote(Long petId, HospitalNoteForm form) {
        //멤버 조회
        Pet pet = petRepository.findOne(petId);
        //게시글 생성
        HospitalNote hospitalNote = HospitalNote.createHospitalNote(pet,form);
        //주문 저장
        hospitalRepository.save(hospitalNote);
        return hospitalNote.getId();
    }
    /** 주문 취소 */
//    @Transactional
//    public void removeHospitalNote(Long hospitalNoteId) {
//        //게시글 엔티티 조회
//        HospitalNote hospitalNote = hospitalRepository.findOne(hospitalNoteId);
//        //게시글 삭제
//        hospitalNote.remove();
//    }

}
