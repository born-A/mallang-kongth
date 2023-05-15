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
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
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

//    @OneToMany(mappedBy = "member")
//    private List<Pet> petList = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleType roleType;


//    @OneToMany(mappedBy = "member")
//    private List<Orders> ordersList = new ArrayList<>();

////    @ManyToMany
//    @Column(name ="ORDER_ID")
//    private Long order_id;


}