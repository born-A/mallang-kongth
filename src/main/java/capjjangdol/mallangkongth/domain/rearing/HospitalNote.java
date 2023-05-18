package capjjangdol.mallangkongth.domain.rearing;

import capjjangdol.mallangkongth.domain.mypage.Member;
import capjjangdol.mallangkongth.domain.mypage.Pet;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class HospitalNote {
    @Id
    @GeneratedValue
    @Column(name = "HOSPITAL_NOTE_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PET_ID")
    private Pet pet;

    private String hospitalName;

    private String dateOfVisit;

    private Long Bill;

    private String memo;

    @Column(name = "IMAGE_URL")
    private String imageUrl;


    //==생성 메서드==//
    public static HospitalNote createHospitalNote(Pet pet, HospitalNoteForm form){
        HospitalNote hospitalNote = new HospitalNote();
        hospitalNote.setPet(pet);
        hospitalNote.setHospitalName(form.getHospitalName());
        hospitalNote.setBill(form.getBill());
        hospitalNote.setMemo(form.getMemo());
        hospitalNote.setDateOfVisit(form.getDateOfVisit());
        hospitalNote.setImageUrl(form.getImageUrl());

        return hospitalNote;
    }
}
