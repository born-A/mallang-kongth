package capjjangdol.mallangkongth.domain.community.comment;

import capjjangdol.mallangkongth.domain.community.board.Board;
import capjjangdol.mallangkongth.domain.community.board.BoardCategory;
import capjjangdol.mallangkongth.domain.mypage.Member;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //한테이블에 다 때려박음
//@DiscriminatorColumn(name = "ctype")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {
    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String commendText;

    @CreationTimestamp
    @Column
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name ="board_id")
    private Board board;




    @Builder
    public Comment(String commendText, Member member, Board board) {
        this.commendText = commendText;
        this.member = member;
        this.board = board;
    }

}
