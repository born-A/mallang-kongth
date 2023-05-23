package capjjangdol.mallangkongth.Controller;

import capjjangdol.mallangkongth.domain.mypage.Member;
import capjjangdol.mallangkongth.domain.mypage.Pet;
import capjjangdol.mallangkongth.domain.mypage.PetForm;
import capjjangdol.mallangkongth.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;

    /**
     * 펫 등록
     */
    @GetMapping(value = "/pets/new")
    public String createForm(Model model) {
        model.addAttribute("petForm", new PetForm());
        return "pets/createPetForm";
    }

    @PostMapping(value = "/pets/new")
    public String create(@Valid PetForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "pets/createPetForm";
        }

        Pet pet = new Pet();
        pet.setName(form.getName());

        petService.create(pet);
        return "redirect:/";
    }

    /**
     * 펫 목록 조회
     */
    @GetMapping(value = "/pets")
    public String list(Model model) {
        List<Pet> pets = petService.findPets();
        model.addAttribute("pets", pets);
        return "pets/petList";
    }

    /**
     * 펫 삭제
     */
}