package capjjangdol.mallangkongth.domain.mypage;

import capjjangdol.mallangkongth.domain.community.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name="category_item")
public class CategoryItem {
    @Id
    @GeneratedValue
    @Column(name = "category_item_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;


}
