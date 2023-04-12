package capjjangdol.mallangkongth.domain.mypage;

import capjjangdol.mallangkongth.domain.Item;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Orders {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private orderStatus status;

    enum orderStatus{
        Complete,
        Cancel,
        Wait;

    }



    @ManyToOne
    @Column(name = "ITEM_ID")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "PET_ID")
    private Pet pet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
