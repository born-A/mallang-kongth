package capjjangdol.mallangkongth.login;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class LoginForm {
    @NotEmpty(message = "?? ?? ????")
    private String name;
    private String email;
    private String pw;
    private String city;
    private String zipcode;
}

