package capjjangdol.mallangkongth.repository.domain.community;

import capjjangdol.mallangkongth.repository.domain.community.board.BoardCategory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category{
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    @OneToMany(mappedBy = "category")
    private List<BoardCategory> boardCategories = new ArrayList<>();

}