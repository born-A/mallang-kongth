package capjjangdol.mallangkongth.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Member{
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private String user_id;
    private String user_name;
    private String user_pw;
    private String user_address;
    @Column(name = "PET_ID")
    private long pet_id;
    @Column(name ="PAYMENT_LIST_ID")
    private String payment_list_id;



}