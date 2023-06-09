package capjjangdol.mallangkongth.domain.mypage;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

//@Embeddable // 어딘가에 내장이 될 수도 있다
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

    public static Address createAddress(String city, String street, String zipcode) {
        Address address = new Address();
        address.city = city;
        address.street = street;
        address.zipcode = zipcode;
        return address;
    }

    public void update(String city, String street, String zipcode){
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
