package capjjangdol.mallangkongth.repository.domain.rearing;
import capjjangdol.mallangkongth.repository.domain.mypage.Pet;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Health {
    @Id @GeneratedValue
    @Column(name = "health_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    private String text;

    @Column(name = "image_url")
    private String imageUrl;

    //==생성 메서드==//
    public static Health createHealth(Pet pet, HealthForm form){
        Health health = new Health();
        health.setText(form.getText());
        health.setImageUrl(form.getImageUrl());

        return health;
    }
}
