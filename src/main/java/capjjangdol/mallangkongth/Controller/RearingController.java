package capjjangdol.mallangkongth.Controller;


import capjjangdol.mallangkongth.domain.mypage.Member;
import capjjangdol.mallangkongth.domain.mypage.Pet;
import capjjangdol.mallangkongth.domain.rearing.*;
import capjjangdol.mallangkongth.service.HealthService;
import capjjangdol.mallangkongth.service.HospitalService;
import capjjangdol.mallangkongth.service.PetService;
import capjjangdol.mallangkongth.service.WalkingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class RearingController {

        private final HospitalService hospitalService;
        private final PetService petService;
        private final HealthService healthService;
        private final WalkingService walkingService;

    /**
     *
     * 병원 기록 등록 - 폼
     */


    @GetMapping(value = "/hospitalNote/new")
        public String createForm(@SessionAttribute(name= SessionConst.LOGIN_MEMBER,required = false)Member member,Model model) {
            List<Pet> pets = petService.findPets(member);
            model.addAttribute("pets", pets);
            model.addAttribute("form",new HospitalNoteForm());
            return "hospitalAddForm";
        }
//        @GetMapping(value = "/hospitalNotes/new")
//        @ResponseBody
//        public PetFormDto createForm() {
//            PetFormDto petFormDto = new PetFormDto();
//            petFormDto.setPets(petService.findPets());
//            petFormDto.setForm(new HospitalNoteForm());
//            return petFormDto;
//        }

//    @GetMapping("/hospitalNotes/ne")
//    @ResponseBody
//    public Map<String, Object> getNoticeList() {
//        Map<String, Object> result = new HashMap<>();
//        List<HospitalFormDto> noticeList = petService.getNoticeList();
//        result.put("noticeList", noticeList);
//        return result;
//    }

    /**
     *
     * 병원 기록 등록 - post
     */
    @PostMapping(value = "/hospitalNote/new")
    public String createHospitalNote(@RequestParam("petId") Long petId, HospitalNoteForm form) {
        hospitalService.saveHospitalNote(petId,form);
        return "redirect:/hospitalNote/list";
    }
//        @PostMapping(value = "/hospitalNotes/{hospitalNoteId}/remove")
//        public String removeHospitalNote(@PathVariable("hospitalNoteId") Long hospitalNoteId) {
//            hospitalService.removeHospitalNote(hospitalNoteId);
//            return "redirect:/hospitalNotes";
//        }


    /**
     * 병원 기록 목록
     */
    @GetMapping(value = "/hospitalNote/list")
    public String list(Model model,@SessionAttribute(name= SessionPet.LOGIN_MEMBER_PET,required = false)Pet pet) {
        List<HospitalNote> hospitalNotes = hospitalService.findHospitalNotes(pet);
        model.addAttribute("hospitalNotes", hospitalNotes);
        return "hospital-listing";
    }

    /**
     * 병원 기록 상세
     */
    @GetMapping("/hospitalNote/view") //localhost:8080/hospitalNotes/view?id=1 //(get방식 파라미터)
    public String hospitalNotesView(Model model, Integer id){

        model.addAttribute("hospitalNote", hospitalService.hospitalNotesView(id));
        return "hospital-view";
    }

    /**
     * 병원 기록 삭제
     */

    @GetMapping("/hospitalNote/delete")
    public String hospitalNotesDeleteV(Integer id){
        hospitalService.deleteById(id);
        return "redirect:/hospitalNote/list";
    }

    /**
     * 병원 기록 수정
     */

    @GetMapping("/hospitalNote/modify/{id}")
    public String hospitalNoteModify(@PathVariable("id") Integer id, Model model){
        List<Pet> pets = petService.findPets();
        model.addAttribute("pets", pets);
        model.addAttribute("hospitalNote", hospitalService.hospitalNotesView(id));
        return "hospitalModify";
    }

    /**
     * 병원 기록 업데이트
     */
    @PostMapping("/hospitalNote/update/{id}")
    public String hospitalNoteUpdate(@PathVariable("id") Integer id, HospitalNoteForm form){
        //기존 기록이 담겨져서 온다.
        HospitalNote hospitalNoteTemp = hospitalService.hospitalNotesView(id);

        //기존에있던 내용을 새로운 내용으로 덮어씌운다.
        hospitalNoteTemp.setHospitalName(form.getHospitalName());
        hospitalNoteTemp.setDateOfVisit(form.getDateOfVisit());
        hospitalNoteTemp.setBill(form.getBill());
        hospitalNoteTemp.setMemo(form.getMemo());
        hospitalNoteTemp.setImageUrl(form.getImageUrl());

        hospitalService.saveHospitalNote(hospitalNoteTemp);
        return "redirect:/hospitalNote/list";
    }

    /**
     * 산책기록 등록 폼
     */
    @GetMapping(value = "/walking/new")
    public String createWalkingForm(Model model,@SessionAttribute(name= SessionConst.LOGIN_MEMBER,required = false)Member member) {
        List<Pet> pets = petService.findPets(member);
        model.addAttribute("pets", pets);
        model.addAttribute("form",new WalkingForm());
        return "walkingAddForm";
    }
    /**
     * 산책 기록 등록 - post
     */
    @PostMapping(value = "/walking/new")
    public String createWalkingForm(@RequestParam("petId") Long petId, WalkingForm form) {
        walkingService.saveWalking(petId,form);
        return "redirect:/walking/list";
    }

    /**
     * 산책 기록 목록
     */
    @GetMapping(value = "/walking/list")
    public String walkingList(Model model,@SessionAttribute(name= SessionPet.LOGIN_MEMBER_PET,required = false)Pet pet) {
        List<Walking> walkings = walkingService.findWalkings(pet);
        model.addAttribute("walkings", walkings);
        return "walking-listing";
    }
    /**
     * 산책 기록 상세 - 날짜별 횟수
     */
    @GetMapping("/walking/day/{id}")
    public String walkingCountView(@PathVariable("id") String id, Model model){
        model.addAttribute("walkingsOfDay", walkingService.findWalkingsByDate(id));
        model.addAttribute("walkingRealDay", walkingService.findWalkingsByDate(id).get(0).getDateOfWalking());
        model.addAttribute("walkingCount", walkingService.takeACount(id));
        return "walking-dayView";
    }

    /**
     * 산책 기록 상세
     */
    @GetMapping("/walking/view")
    public String walkingView(Model model, Long id){
        model.addAttribute("walking", walkingService.walkingView(id));
        return "walking/walkingView";
    }

    /**
     * 산책 기록 삭제
     */

    @GetMapping("/walking/delete")
    public String walkingDelete(Long id){
        walkingService.deleteById(id);
        return "redirect:/walking/list";
    }

    /**
     * 산책 기록 수정
     */

    @GetMapping("/walking/modify/{id}")
    public String walkingModify(@PathVariable("id") Long id, Model model){
        List<Pet> pets = petService.findPets();
        model.addAttribute("pets", pets);
        model.addAttribute("walking", walkingService.walkingView(id));
        return "walking/walkingModify";
    }

    /**
     * 산책 기록 업데이트
     */
    @PostMapping("/walking/update/{id}")
    public String walkingUpdate(@PathVariable("id") Long id, WalkingForm form){
        Walking walkingTemp = walkingService.walkingView(id);

        walkingTemp.setDateOfWalking(form.getDateOfWalking());

        walkingService.saveWalking(walkingTemp);
        return "redirect:/walking/list";
    }

    /**
     * 건강기록 등록 폼
     */
    @GetMapping(value = "/health/new")
    public String createHealthForm(Model model) {
        List<Pet> pets = petService.findPets();
        model.addAttribute("pets", pets);
        model.addAttribute("form",new HealthForm());
        return "health/healthForm";
    }
    /**
     * 건강 기록 등록 - post
     */
    @PostMapping(value = "/health/new")
    public String createHealthForm(@RequestParam("petId") Long petId, HealthForm form) {
        healthService.saveHealth(petId,form);
        return "redirect:/health/list";
    }

    /**
     * 건강 기록 목록
     */
    @GetMapping(value = "/health/list")
    public String healhList(Model model) {
        List<Health> healths = healthService.findHealths();
        model.addAttribute("healths", healths);
        return "health/healthList";
    }

    /**
     * 건강 기록 상세
     */
    @GetMapping("/health/view")
    public String healthView(Model model, Long id){
        model.addAttribute("health", healthService.healthView(id));
        return "health/healthView";
    }

    /**
     * 건강 기록 삭제
     */

    @GetMapping("/health/delete")
    public String healthDelete(Long id){
        healthService.deleteById(id);
        return "redirect:/health/list";
    }

    /**
     * 건강 기록 수정
     */

    @GetMapping("/health/modify/{id}")
    public String healthModify(@PathVariable("id") Long id, Model model){
        List<Pet> pets = petService.findPets();
        model.addAttribute("pets", pets);
        model.addAttribute("health", healthService.healthView(id));
        return "health/healthModify";
    }

    /**
     * 건강 기록 업데이트
     */
    @PostMapping("/health/update/{id}")
    public String healthUpdate(@PathVariable("id") Long id, HealthForm form){
        Health healthTemp = healthService.healthView(id);

        healthTemp.setText(form.getText());
        healthTemp.setImageUrl(form.getImageUrl());

        healthService.saveHealth(healthTemp);
        return "redirect:/health/list";
    }
}