package capjjangdol.mallangkongth.domain.mypage;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Pet {
    @Id
    @GeneratedValue
    @Column(name = "pet_id")
    private Long id;

    @Column(name = "pet_name")
    private String name;
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
