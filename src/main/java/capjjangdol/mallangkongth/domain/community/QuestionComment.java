package capjjangdol.mallangkongth.domain.community;

import capjjangdol.mallangkongth.domain.community.board.Question;
import capjjangdol.mallangkongth.domain.mypage.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class QuestionComment {

    @Id
    @GeneratedValue
    @Column(name = "QUESTION_COMMENT_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    private String mainText;
}
