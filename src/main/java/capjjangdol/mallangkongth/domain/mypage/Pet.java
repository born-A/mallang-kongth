package capjjangdol.mallangkongth.domain.mypage;

import capjjangdol.mallangkongth.domain.rearing.HospitalNote;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HospitalNote> hospitalNoteList = new ArrayList<>();
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
