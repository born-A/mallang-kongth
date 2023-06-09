package capjjangdol.mallangkongth.domain.rearing;

import capjjangdol.mallangkongth.domain.mypage.Pet;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@Setter
public class FoodServingTime {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "food_bowl_id")
    private FoodBowl foodBowl;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime servingTime;

    private Integer servingSize;
}
