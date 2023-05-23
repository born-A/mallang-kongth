package capjjangdol.mallangkongth.Controller;


import capjjangdol.mallangkongth.domain.mypage.Pet;
import capjjangdol.mallangkongth.domain.rearing.*;
import capjjangdol.mallangkongth.dto.HospitalFormDto;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
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


//    @GetMapping(value = "/hospitalNotes/new")
//        public String createForm(Model model) {
//            List<Pet> pets = petService.findPets();
//            model.addAttribute("pets", pets);
//            model.addAttribute("form",new HospitalNoteForm());
////            return "hospitalNotes/hospitalNoteForm";
//            return "rearing/HospitalForm.js";
//        }
        @GetMapping(value = "/hospitalNotes/new")
        @ResponseBody
        public PetFormDto createForm() {
            PetFormDto petFormDto = new PetFormDto();
            petFormDto.setPets(petService.findPets());
            petFormDto.setForm(new HospitalNoteForm());
            return petFormDto;
        }

//    @GetMapping("/hospitalNotes/new")
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
//    @GetMapping(value = "/hospitalNotes")
//    public String list(Model model) {
//        List<HospitalNote> hospitalNotes = hospitalService.findHospitalNotes();
//        model.addAttribute("hospitalNotes", hospitalNotes);
//        return "hospitalNotes/hospitalNoteList";
//    }

    @GetMapping("/hospitalNotes")
    @ResponseBody
    public Map<String, Object> getHospitalNoteList() {
        Map<String, Object> result = new HashMap<>();
        List<HospitalNote> hospitalNoteList = hospitalService.findHospitalNotes();
        result.put("hospitalNoteList", hospitalNoteList);
        return result;
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