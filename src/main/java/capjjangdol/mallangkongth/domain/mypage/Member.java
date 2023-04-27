package capjjangdol.mallangkongth.domain.mypage;

import jdk.nashorn.internal.runtime.Debug;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@RequiredArgsConstructor
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false, length = 50, unique = true)
    private String user_id;
    @Column(nullable = false,length = 30, unique = true)
    private String name;
    @Column(length = 100)
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

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

////    @ManyToMany
//    @Column(name ="ORDER_ID")
//    private Long order_id;



}