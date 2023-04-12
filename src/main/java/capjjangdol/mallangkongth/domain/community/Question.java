package capjjangdol.mallangkongth.domain.community;

import capjjangdol.mallangkongth.domain.mypage.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Question {
    @Id
    @GeneratedValue
    @Column(name = "QUESTION_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    //private Category category;

    private String mainText;
}
