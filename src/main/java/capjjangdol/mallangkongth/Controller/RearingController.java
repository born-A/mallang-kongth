package capjjangdol.mallangkongth.Controller;

import capjjangdol.mallangkongth.domain.mypage.Pet;
import capjjangdol.mallangkongth.domain.rearing.HospitalNote;
import capjjangdol.mallangkongth.domain.rearing.HospitalNoteForm;
import capjjangdol.mallangkongth.service.HospitalService;
import capjjangdol.mallangkongth.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class RearingController {
        private final HospitalService hospitalService;
        private final PetService petService;


    @GetMapping(value = "/hospitalNotes/new")
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
    /**
     * 병원 기록 목록
     */
    @GetMapping(value = "/hospitalNotes")
    public String list(Model model) {
        List<HospitalNote> hospitalNotes = hospitalService.findHospitalNotes();
        model.addAttribute("hospitalNotes", hospitalNotes);
        return "hospitalNotes/hospitalNoteList";
    }
}