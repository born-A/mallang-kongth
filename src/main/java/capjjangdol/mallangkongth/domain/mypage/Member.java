package capjjangdol.mallangkongth.repository.domain.mypage;

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
    private String email; //principal
    @Column(nullable = false,unique = true) //credential
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

    public void setEmail(String email){
        this.email = email;
    }
    public void setPw(String pw){
        this.pw = pw;
    }



}