package capjjangdol.mallangkongth.domain.mypage;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public abstract class Item {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;
//
//    @OneToMany(mappedBy = "item")
//    private List<OrderItem> orderItems = new ArrayList<>();
//
    private String name;
//    private String category;

//    private String information; //????
//    private String company; //???

    private int price;
    private int stockQuantity;
    @ManyToMany(mappedBy = "items")
    private List<ItemCategory> categories = new ArrayList<ItemCategory>();

    //==비즈니스 로직==//
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }
    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;
        if (restStock > 0) {
            this.stockQuantity = restStock;
        }

    }

}
