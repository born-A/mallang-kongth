package capjjangdol.mallangkongth.domain.community;

import capjjangdol.mallangkongth.domain.mypage.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Missing {
    @Id
    @GeneratedValue
    @Column(name = "MISSING_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    private String breed;

    private String area;

    private Enum<Sex> sex;

    @Column(name = "RESCUE_DATE")
    private LocalDateTime rescueDate;

    private String mainText;
}
