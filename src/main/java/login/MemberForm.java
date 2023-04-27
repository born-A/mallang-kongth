package login;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class MemberForm {
    @NotEmpty(message = "?? ?? ????")
    private String name;
    private String city;
    private String zipcode;
}

