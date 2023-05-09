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
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "food_bowl_id")
    private FoodBowl foodBowl;

    @Column(name = "ingredients")
    @ElementCollection(targetClass=String.class)
    private List<String> ingredients = new ArrayList<String>();

}
