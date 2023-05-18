package capjjangdol.mallangkongth.repository.domain.mypage;

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

    @AllArgsConstructor
    @Data
    @Builder
    public static class SignUpForm {


            private Long id;

            @NotBlank(message = "이름은 필수 입력 값입니다.")
            private String name;

            @NotEmpty(message = "이메일은 필수 입력 값입니다.")
            @Email(message = "이메일 형식으로 입력해주세요.")
            private String email;

            @NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
            @Length(min = 4, max = 16, message = "비밀번호는 4자 이상, 16자 이하로 입력해주세요.")
            private String pw;

            private Address address;

            private RoleType roleType;
            private List<Orders> ordersList = new ArrayList<>();

            private Pet pet;

    //        public void encryptPassword(String BCryptpassword) {
    //            this.pw = BCryptpassword;
    //        }
            @Builder
            public SignUpForm(String name, String email, String pw, Address address) {
               this.name = name;
               this.email = email;
               this.pw = pw;
               this.address  = address;
            }


    }
}
