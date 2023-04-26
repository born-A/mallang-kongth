package capjjangdol.mallangkongth.domain.mypage;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member{
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String name;
    private String pw;

    @Embedded
    private String address;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @OneToMany(mappedBy = "member")
    private List<Orders> ordersList = new ArrayList<>();

////    @ManyToMany
//    @Column(name ="ORDER_ID")
//    private Long order_id;



}