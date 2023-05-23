package capjjangdol.mallangkongth.domain.rearing;


import capjjangdol.mallangkongth.domain.mypage.Pet;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Walking {
    @Id
    @GeneratedValue
    @Column(name = "WALKKING_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PET_ID")
    private Pet pet;

    @Column(name = "DATE_OF_VISIT")
    private LocalDateTime dateOfWalking;

    //==생성 메서드==//
    public static Walking createWalking(Pet pet, WalkingForm form){
        Walking walking = new Walking();
        walking.setDateOfWalking(form.getDateOfWalking());

        return walking;
    }
}
