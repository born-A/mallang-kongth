package capjjangdol.mallangkongth.domain.mypage;

import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.Collection;

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

    public static Member createMember(JoinForm joinForm, PasswordEncoder passwordEncoder){
        Member member = new Member();
        member.setName(member.getName());
        member.setEmail(member.getEmail());
        member.setAddress(member.getAddress());
        String pw = passwordEncoder.encode(joinForm.getPw());
        member.setPw(member.getPw());
        member.setRoleType(RoleType.USER);
        return member;

    }


    public Collection<Orders> getOrders() {
        return null;
    }
}