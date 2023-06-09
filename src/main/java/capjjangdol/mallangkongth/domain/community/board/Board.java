package capjjangdol.mallangkongth.domain.community.board;

import capjjangdol.mallangkongth.domain.community.Time;
import capjjangdol.mallangkongth.domain.mypage.Member;
import lombok.*;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //한테이블에 다 때려박음
@DiscriminatorColumn(name = "dtype")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends Time {
    @Id
    @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "category")
    private List<BoardCategory> boardCategories = new ArrayList<>();

    private String title;
    private String context;
    @Builder
    public Board(Long id, String title, String context, Member member){
        Assert.hasText(title, "제목을 입력하세요");
        Assert.hasText(context,"내용을 입력하세요");
        this.id = id;
        this.title = title;
        this.context = context;
        this.member = member;
    }
}
