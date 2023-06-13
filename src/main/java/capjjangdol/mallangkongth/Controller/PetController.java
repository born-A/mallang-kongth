package capjjangdol.mallangkongth.Controller;

import capjjangdol.mallangkongth.domain.file.FileEntity;
import capjjangdol.mallangkongth.domain.mypage.Member;
import capjjangdol.mallangkongth.domain.mypage.Pet;
import capjjangdol.mallangkongth.domain.mypage.PetForm;
import capjjangdol.mallangkongth.repository.FileRepository;
import capjjangdol.mallangkongth.service.FileService;
import capjjangdol.mallangkongth.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;
    private final FileRepository fileRepository;


    /**
     * 펫 등록
     */
    @GetMapping(value = "/pets/new")
    public String createForm(@SessionAttribute(name= SessionConst.LOGIN_MEMBER,required = false)Member member,Model model) {
        model.addAttribute("member", member);
        Pet pet = new Pet();
        pet.setGender(true);
        model.addAttribute("pet", pet);
        model.addAttribute("petForm", new PetForm());

        List<String> breeds = new ArrayList<>();
        breeds.add("말티즈");
        breeds.add("치와와");
        breeds.add("요크셔테리어");
        model.addAttribute("breeds", breeds);

        List<FileEntity> files = fileRepository.findAll();
        model.addAttribute("all",files);
        return "petAddListing";
    }

    @PostMapping(value = "/pets/new")
    public String create(@SessionAttribute(name= SessionConst.LOGIN_MEMBER,required = false) Member member,
                         @Valid PetForm form, BindingResult result,HttpServletRequest request) {
//        if (result.hasErrors()) {
////            return "pets/createPetForm";
//            return "/index";
//        }

        Pet pet = new Pet();
        pet.setMember(member);
        pet.setName(form.getName());
        pet.setGender(form.isGender());
        pet.setWeight(form.getWeight());
        pet.setBirthday(form.getBirthday());
        pet.setBreed(form.getBreed());
        petService.savePet(pet);

        return "redirect:/";
    }

    /**
     * 펫 목록 조회
     */
    @GetMapping(value = "/pets")
    public String list(Model model,@SessionAttribute(name= SessionConst.LOGIN_MEMBER,required = false) Member member) {
        List<Pet> pets = petService.findPets(member);
        model.addAttribute("member", member);
        model.addAttribute("pets", pets);
        List<FileEntity> files = fileRepository.findAll();
        model.addAttribute("all",files);
        return "pets/pet-listings";
    }
    /**
     * 펫 상세
     */
    @GetMapping("/pets/view")
    public String petView(Model model, Long id){
        model.addAttribute("pet", petService.petView(id));
        return "pets/petView";
    }

    /**
     * 펫 삭제
     */

    @GetMapping("/pets/delete")
    public String petDelete(Long id){
        petService.deleteById(id);
        return "redirect:/pets";
    }

    /**
     * 펫 수정
     */

    @GetMapping("/pets/modify/{id}")
    public String petModify(@PathVariable("id") Long id, Model model){
        model.addAttribute("pet", petService.petView(id));
        List<String> breeds = new ArrayList<>();
        breeds.add("말티즈");
        breeds.add("치와와");
        breeds.add("요크셔테리어");
        model.addAttribute("breeds", breeds);
        return "pets/petModify";
    }

    /**
     * 펫 업데이트
     */
    @PostMapping("/pets/update/{id}")
    public String petUpdate(@PathVariable("id") Long id, PetForm form){
        Pet petTemp = petService.petView(id);

        petTemp.setName(form.getName());
        petTemp.setBirthday(form.getBirthday());
        petTemp.setGender(form.isGender());
        petTemp.setWeight(form.getWeight());
        petService.savePet(petTemp);
        return "redirect:/pets";
    }
}