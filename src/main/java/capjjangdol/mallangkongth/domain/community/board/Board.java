package capjjangdol.mallangkongth.domain.community.board;


import capjjangdol.mallangkongth.domain.community.Category;
import capjjangdol.mallangkongth.domain.community.Time;
import capjjangdol.mallangkongth.domain.mypage.Member;
import lombok.*;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //한테이블에 다 때려박음
@DiscriminatorColumn(name = "dtype")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends Time {
    @Id
    @GeneratedValue
    @Column(name = "board_id")
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "member_id")
//    private Member member;

    private String writer;

    @Embedded
    private Category category;
    private String title;
    private String content;
    @Builder
    public Board(Long id, String title, String content, String writer, Category category){
        Assert.hasText(title, "제목을 입력하세요");
        Assert.hasText(content,"내용을 입력하세요");
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.category = category;
    }
}
