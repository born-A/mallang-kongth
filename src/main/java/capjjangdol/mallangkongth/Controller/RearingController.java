package capjjangdol.mallangkongth.Controller;


import capjjangdol.mallangkongth.domain.mypage.Pet;
import capjjangdol.mallangkongth.domain.rearing.HospitalNoteForm;
import capjjangdol.mallangkongth.repository.WaterBowlRepository;
import capjjangdol.mallangkongth.service.HospitalService;
import capjjangdol.mallangkongth.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class RearingController {
    private final HospitalService hospitalService;
    private final PetService petService;

    @Autowired
    private WaterBowlRepository waterBowlRepository;

    //급수기 테스트용 코드
    @GetMapping ("/water")
    public String renewalWaterBowl(Model model){
        int value = waterBowlRepository.findRemaining().get(0);
        model.addAttribute("water", String.valueOf(value));
        return "waterBowlTest";
    }


    @GetMapping(value = "/hospitalNote/new")
    public String createForm(Model model) {
        List<Pet> pets = petService.findPets();
        model.addAttribute("pets", pets);
        model.addAttribute("form",new HospitalNoteForm());
        return "hospitalNotes/hospitalNoteForm";
    }

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

}