package capjjangdol.mallangkongth.domain.community;

import capjjangdol.mallangkongth.domain.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class InformationComment {

    @Id
    @GeneratedValue
    @Column(name = "INFORMATION_COMMENT_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "INFORMATION_ID")
    private Information information;

    private String mainText;
}
