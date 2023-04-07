
package capjjangdol.mallangkongth.domain;

import javax.persistence.*;

@Entity
public class Pet {
    @Id
    @GeneratedValue
    @Column(name = "PET_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
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
