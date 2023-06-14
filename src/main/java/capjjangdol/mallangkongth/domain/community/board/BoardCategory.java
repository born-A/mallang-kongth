package capjjangdol.mallangkongth.domain.community.board;

import capjjangdol.mallangkongth.domain.community.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
public class BoardCategory {
    @Id @GeneratedValue
    @Column(name = "board_category_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private BoardCategory category;

}
