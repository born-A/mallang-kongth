package capjjangdol.mallangkongth.domain.community;

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
public class Question {
    @Id
    @GeneratedValue
    @Column(name = "QUESTION_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToMany(mappedBy = "boards")
    private List<Category> categories = new ArrayList<>();

    private String mainText;
}
