package capjjangdol.mallangkongth.repository.domain.mypage;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@Data
//@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Member{
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String pw;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleType roleType;

    @Builder
    public Member(String name, String email, String pw, Address address, RoleType roleType) {
        this.name = name;
        this.email = email;
        this.pw = pw;
        this.address = address;
        this.roleType = roleType;
    }

}