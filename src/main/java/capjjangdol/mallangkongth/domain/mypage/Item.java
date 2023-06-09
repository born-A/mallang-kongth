package capjjangdol.mallangkongth.domain.mypage;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
public abstract class Item {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    @OneToMany(mappedBy = "item")
    private List<OrderItem> orderItems = new ArrayList<>();

    private String name;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<CategoryItem> categoryItems = new ArrayList<>();

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    protected Member member;


//    private String information; //????
//    private String company; //???

    private int price;
    private int stockQuantity;
//    @ManyToMany(mappedBy = "items")
//    private List<Category> categories = new ArrayList<Category>();

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
    /** Item 객체 업데이트 **/
    public void updateBaseItem(String name, int price, int stockQuantity){
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

}
