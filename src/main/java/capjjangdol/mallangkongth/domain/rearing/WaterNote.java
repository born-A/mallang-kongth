package capjjangdol.mallangkongth.domain.rearing;

import capjjangdol.mallangkongth.domain.mypage.Pet;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class WaterNote {
    @Id
    @GeneratedValue
    @Column(name = "WATER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PET_ID")
    private Pet pet;

    @Column(name = "WATER_AMOUNT")
    private Integer amount;
}
