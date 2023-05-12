package capjjangdol.mallangkongth.domain.community.comment;

import capjjangdol.mallangkongth.domain.community.board.Board;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class BoardComment {
    @Id
    @GeneratedValue
    @Column(name = "board_comment_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

}
