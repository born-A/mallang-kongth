package capjjangdol.mallangkongth.domain.rearing;

import capjjangdol.mallangkongth.domain.mypage.Pet;
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
    @Column(name = "hospital_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    private String hospitalName;

    private LocalDateTime dateOfVisit;

    private Long Bill;

    private String memo;

    @Column(name = "image_url")
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
