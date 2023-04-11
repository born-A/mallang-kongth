package capjjangdol.mallangkongth.domain.community;

import capjjangdol.mallangkongth.domain.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class MissingComment {

    @Id
    @GeneratedValue
    @Column(name = "MISSING_COMMENT_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "MISIING_ID")
    private Missing missing;

    private String mainText;
}
