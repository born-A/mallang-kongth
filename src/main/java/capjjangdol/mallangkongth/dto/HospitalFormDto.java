package capjjangdol.mallangkongth.dto;

import capjjangdol.mallangkongth.domain.mypage.Pet;
import capjjangdol.mallangkongth.domain.rearing.HospitalNoteForm;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class HospitalFormDto {
    public List<Pet> pets;
    public HospitalNoteForm form;
}
