package capjjangdol.mallangkongth.service;

import capjjangdol.mallangkongth.domain.mypage.Pet;
import capjjangdol.mallangkongth.domain.rearing.Health;
import capjjangdol.mallangkongth.domain.rearing.Walking;
import capjjangdol.mallangkongth.domain.rearing.WalkingForm;
import capjjangdol.mallangkongth.repository.PetRepository;
import capjjangdol.mallangkongth.repository.WalkingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class WalkingService {
    private final PetRepository petRepository;
    private final WalkingRepository walkingRepository;

    @Transactional
    public Long saveWalking(Long petId, WalkingForm form) {
        //엔티티 조회
        Pet pet = petRepository.findById(petId).get();
        Walking walking = Walking.createWalking(pet,form);
        walkingRepository.save(walking);
        return walking.getId();
    }

    @Transactional
    public void saveWalking(Walking walking) {
        walkingRepository.save(walking);
    }

    //전체 산책 기록
    public List<Walking> findWalkings() {
        return walkingRepository.findAll();
    }

    //날짜별 산책
    public List<Walking> findWalkingsByDate(String date){ return walkingRepository.findByDateOfWalking(date);}
    //산책 기록 하나 조회
    public Walking findOne(Long walkingId) {
        return walkingRepository.findById(walkingId).get();
    }


    //날짜별 산책 횟수 카운트
//    public int takeACount(LocalDateTime dateTime){
//        int count = 0;
//        List<Walking> walkings = walkingRepository.findAllOfDay(dateTime);
//        for(Walking walking : walkings){
//            count++;
//        }
//        return count;
//    }
    public Long takeACount(String date){
        return walkingRepository.countByDateOfWalking(date);
    }
    public Walking walkingView(Long id){
        return walkingRepository.findById(id).get();
    }
    @Transactional
    public void deleteById(Long walkingId){
        walkingRepository.deleteById(walkingId);
    }

}
