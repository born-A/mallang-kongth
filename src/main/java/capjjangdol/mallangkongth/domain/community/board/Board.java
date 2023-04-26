package capjjangdol.mallangkongth.domain.community.board;

import capjjangdol.mallangkongth.domain.mypage.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //한테이블에 다 때려박음
@DiscriminatorColumn(name = "dtype")
public abstract class Board {
    @Id
    @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "category")
    private List<BoardCategory> boardCategories = new ArrayList<>();

    private String mainText;
}
