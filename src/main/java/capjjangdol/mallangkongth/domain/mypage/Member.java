package capjjangdol.mallangkongth.domain.mypage;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Member{
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String user_id;
    @Column(nullable = false,unique = true)
    private String name;
    @Column
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