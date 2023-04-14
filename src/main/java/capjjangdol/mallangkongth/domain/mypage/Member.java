package capjjangdol.mallangkongth.domain.mypage;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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

////    @ManyToMany
//    @Column(name ="ORDER_ID")
//    private Long order_id;



}