package capjjangdol.mallangkongth.Controller;


import capjjangdol.mallangkongth.domain.mypage.Pet;
import capjjangdol.mallangkongth.domain.rearing.*;
import capjjangdol.mallangkongth.repository.FoodBowlRepository;
import capjjangdol.mallangkongth.repository.FoodServingRepository;
import capjjangdol.mallangkongth.repository.WaterBowlRepository;
import capjjangdol.mallangkongth.dto.PetFormDto;
import capjjangdol.mallangkongth.service.HealthService;
import capjjangdol.mallangkongth.service.HospitalService;
import capjjangdol.mallangkongth.service.PetService;
import capjjangdol.mallangkongth.service.WalkingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class RearingController {

        private final HospitalService hospitalService;
        private final PetService petService;
        private final HealthService healthService;
        private final WalkingService walkingService;
        private final FoodBowlRepository foodBowlRepository;
        private final WaterBowlRepository waterBowlRepository;
        private final FoodServingRepository foodServingRepository;

    /**
     *
     * 병원 기록 등록 - 폼
     */

    //급수기, 급식기 테스트용 코드
    @GetMapping ("/water")
    public String renewalWaterBowl(Model model){
        int value1 = waterBowlRepository.findRemaining().get(0);
        int value2 = waterBowlRepository.findCurrentEatingAmount().get(0);
        int value3 = foodBowlRepository.findRemaining().get(0);
        int value4 = foodBowlRepository.findCurrentEatingAmount().get(0);
        model.addAttribute("water1", String.valueOf(value1));
        model.addAttribute("water2", String.valueOf(value2));
        model.addAttribute("food1", String.valueOf(value3));
        model.addAttribute("food2", String.valueOf(value4));
        model.addAttribute("foodServingForm", new FoodServingForm());
        return "waterBowlTest";
    }

    //급식기 테스트용 코드
    @PostMapping("/water")
    public String submitForm(@ModelAttribute("foodServingForm") FoodServingForm foodServingForm) {
        // 폼에서 받아온 값 처리
        int servingSize = foodServingForm.getServingSize();
        FoodServing foodServing = new FoodServing();
        foodServing.setFoodServingSize(servingSize);
        foodServingRepository.save(foodServing);
        return "waterBowlTest";
    }


//    @GetMapping(value = "/hospitalNotes/new")
//        public String createForm(Model model) {
//            List<Pet> pets = petService.findPets();
//            model.addAttribute("pets", pets);
//            model.addAttribute("form",new HospitalNoteForm());
////            return "hospitalNotes/hospitalNoteForm";
//            return "rearing/HospitalForm.js";
//        }
        @GetMapping(value = "/hospitalNotes/new")
        public PetFormDto createForm() {
            PetFormDto petFormDto = new PetFormDto();
            petFormDto.setPets(petService.findPets());
            petFormDto.setForm(new HospitalNoteForm());
            return petFormDto;
        }

    /**
     *
     * 병원 기록 등록 - post
     */
    @PostMapping(value = "/hospitalNotes/new")
    public String createHospitalNote(@RequestParam("petId") Long petId, HospitalNoteForm form) {
        hospitalService.saveHospitalNote(petId,form);
        return "redirect:/hospitalNotes";
    }
//        @PostMapping(value = "/hospitalNotes/{hospitalNoteId}/remove")
//        public String removeHospitalNote(@PathVariable("hospitalNoteId") Long hospitalNoteId) {
//            hospitalService.removeHospitalNote(hospitalNoteId);
//            return "redirect:/hospitalNotes";
//        }

    @GetMapping("/hospitalNotes/delete")
    public String hospitalNotesDelete(Long id){
        hospitalService.deleteById(id);

        return "redirect:/hospitalNotes";
    }
    /**
     * 병원 기록 목록
     */
    @GetMapping(value = "/hospitalNotes")
    public String list(Model model) {
        List<HospitalNote> hospitalNotes = hospitalService.findHospitalNotes();
        model.addAttribute("hospitalNotes", hospitalNotes);
        return "hospitalNotes/hospitalNoteList";
    }

    /**
     *
     * 산책 기록 등록 - 폼
     */

    @GetMapping(value = "/walkings/new")
    public String createWalkingForm(Model model) {
        List<Pet> pets = petService.findPets();
        model.addAttribute("pets", pets);
        model.addAttribute("form",new WalkingForm());
        return "walkings/walkingForm";
    }
    /**
     *
     * 산책 기록 등록 - post
     */
    @PostMapping(value = "/walkings/new")
    public String createWalking(@RequestParam("petId") Long petId, WalkingForm form) {
        walkingService.saveWalking(petId,form);
        return "redirect:/walkings";
    }

    /**
     * 산책 기록 목록
     */
    @GetMapping(value = "/walkings")
    public String walkingList(Model model) {
        List<Walking> walkings = walkingService.findWalkings();
        model.addAttribute("walking", walkings);
        return "walkings/walkingList";
    }

    /**
     *
     * 산책 기록 등록 - 폼
     */

    @GetMapping(value = "/healths/new")
    public String createHealthForm(Model model) {
        List<Pet> pets = petService.findPets();
        model.addAttribute("pets", pets);
        model.addAttribute("form",new HealthForm());
        return "healths/healthForm";
    }
    /**
     *
     * 건강 기록 등록 - post
     */
    @PostMapping(value = "/healths/new")
    public String createHealth(@RequestParam("petId") Long petId, HealthForm form) {
        healthService.saveHealth(petId,form);
        return "redirect:/healths";
    }

    /**
     * 건강 기록 목록
     */
    @GetMapping(value = "/healths")
    public String healthList(Model model) {
        List<Health> healths = healthService.findHealths();
        model.addAttribute("healths", healths);
        return "healths/healthList";
    }
}