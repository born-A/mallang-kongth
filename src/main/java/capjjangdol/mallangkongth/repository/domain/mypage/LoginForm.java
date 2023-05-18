package capjjangdol.mallangkongth.repository.domain.mypage;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class LoginForm {
    @NotEmpty(message = "?? ?? ????")
    private String email;
    private String pw;

}

