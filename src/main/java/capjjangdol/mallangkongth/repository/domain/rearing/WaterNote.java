package capjjangdol.mallangkongth.repository.domain.rearing;

import capjjangdol.mallangkongth.repository.domain.mypage.Pet;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class WaterNote {
    @Id
    @GeneratedValue
    @Column(name = "water_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @Column(name = "water_amount")
    private Long amount;
}
