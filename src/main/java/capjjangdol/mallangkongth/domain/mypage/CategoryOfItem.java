package capjjangdol.mallangkongth.domain.mypage;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class CategoryOfItem {
    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<CategoryItem> categoryItems = new ArrayList<>();
//    @ManyToMany
//    @JoinTable(name = "category_item", joinColumns = @JoinColumn(name = "category_id"),
//            inverseJoinColumns = @JoinColumn(name = "item_id"))
//    private List<Item> items = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private CategoryOfItem parent;
    @OneToMany(mappedBy = "parent")
    private List<CategoryOfItem> child = new ArrayList<>();
    public void addChildCategory(CategoryOfItem child) {
        this.child.add(child);
        child.setParent(this);
    }
}