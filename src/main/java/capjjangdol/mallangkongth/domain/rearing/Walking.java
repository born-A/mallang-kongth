package capjjangdol.mallangkongth.domain.rearing;


import capjjangdol.mallangkongth.domain.mypage.Member;
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
    @Column(name = "walking_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "date_of_visit")
    private String dateOfWalking;

    //==생성 메서드==//
    public static Walking createWalking(Pet pet, WalkingForm form){
        Walking walking = new Walking();
        walking.setPet(pet);
        walking.setMember(pet.getMember());
        walking.setDateOfWalking(form.getDateOfWalking());

        return walking;
    }
}
