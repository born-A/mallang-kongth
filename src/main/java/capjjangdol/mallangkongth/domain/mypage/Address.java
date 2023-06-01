package capjjangdol.mallangkongth.domain.mypage;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Embeddable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Embeddable // 어딘가에 내장이 될 수도 있다
@Getter
@Setter
public class Address {
    private String city;
    private String street;
    private String zipcode;

    protected Address() {

    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }



}
