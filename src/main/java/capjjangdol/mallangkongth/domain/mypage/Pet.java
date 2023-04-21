package capjjangdol.mallangkongth.domain.mypage;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pet {
    @Id
    @GeneratedValue
    @Column(name = "pet_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
