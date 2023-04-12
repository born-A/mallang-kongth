package capjjangdol.mallangkongth.domain.mypage;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Member{
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String name;
    private String pw;

    @Embedded
    private String address;

    @ManyToOne
    @Column(name = "PET_ID")
    private Pet pet;

////    @ManyToMany
//    @Column(name ="ORDER_ID")
//    private Long order_id;



}