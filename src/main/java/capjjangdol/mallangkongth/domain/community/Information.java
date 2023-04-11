package capjjangdol.mallangkongth.domain.community;

import capjjangdol.mallangkongth.domain.Member;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Information {

    @Id @GeneratedValue
    @Column(name = "INFORMATION_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    //private Category category;


    private String mainText;

}
