package capjjangdol.mallangkongth.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member{
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_pw")
    private String pw;

    @Column(name = "user_address")
    private String address;

    @OneToMany(mappedBy = "member")
    private List<Pet> petList = new ArrayList<>();


    @Column(name ="PAYMENT_LIST_ID")
    private String payment_list_id;


}