package capjjangdol.mallangkongth.domain;


import capjjangdol.mallangkongth.domain.mypage.Orders;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

@OneToMany(mappedBy = "item")
    private List<Orders> ordersList = new ArrayList<>();

    private String name;
    private String category;
    private Integer price;
    private Integer stock; //???
    private String information; //????
    private String company; //???

}
