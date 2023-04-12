package capjjangdol.mallangkongth.domain.rearing;

import capjjangdol.mallangkongth.domain.mypage.Pet;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class FoodNote {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PET_ID")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "FOOD_BOWL_ID")
    private FoodBowl foodBowl;

    @Column(name = "INGREDIENTS")
    @ElementCollection(targetClass=String.class)
    private List<String> ingredients = new ArrayList<String>();

}
