package capjjangdol.mallangkongth.domain.mypage;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "id")
@RequiredArgsConstructor
@AllArgsConstructor
public class Member{
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false,unique = true)
    private String name;
    @Column
    private String pw;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleType roleType;
    @Override
    public String toString(){
        return "member{"+
                "id=" + id +
                ", email=" + email +
                ", pw="+pw+
                ", name="+name+
                ", roletype="+roleType+
                ", address="+address+
                "}";

    }


}