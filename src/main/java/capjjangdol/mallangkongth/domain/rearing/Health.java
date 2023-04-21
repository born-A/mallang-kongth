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
    @Column(name = "health_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    private String text;

    @Column(name = "image_url")
    private String imageUrl;
}
