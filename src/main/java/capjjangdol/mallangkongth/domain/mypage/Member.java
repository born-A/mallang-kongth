package capjjangdol.mallangkongth.repository.domain.mypage;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.stream.Collectors;

@Entity
@Getter
@Builder
@EqualsAndHashCode(of = "id")
@RequiredArgsConstructor
@AllArgsConstructor
public class Member{
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String email; //principal

    @Column(nullable = false,unique = true) //credential
    private String name;

    @Column(nullable = false)
    private String pw;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleType roleType;

    public void setEmail(String email){
        this.email = email;
    }
    public void setPw(String pw){
        this.pw = pw;
    }



}