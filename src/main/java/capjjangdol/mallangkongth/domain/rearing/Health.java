package capjjangdol.mallangkongth.domain.rearing;
import capjjangdol.mallangkongth.domain.mypage.Pet;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Health {
    @Id @GeneratedValue
    @Column(name = "HEALTH_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PET_ID")
    private Pet pet;

    private String text;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    //==생성 메서드==//
    public static Health createHealth(Pet pet, HealthForm form){
        Health health = new Health();
        health.setText(form.getText());
        health.setImageUrl(form.getImageUrl());

        return health;
    }
}
