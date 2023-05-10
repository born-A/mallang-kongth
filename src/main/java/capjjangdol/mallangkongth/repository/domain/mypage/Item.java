package capjjangdol.mallangkongth.repository.domain.mypage;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    @OneToMany(mappedBy = "item")
    private List<OrderItem> orderItems = new ArrayList<>();

    private String name;
    private String category;
    private Integer price;
    private Integer stock; //???
    private String information; //????
    private String company; //???

}
