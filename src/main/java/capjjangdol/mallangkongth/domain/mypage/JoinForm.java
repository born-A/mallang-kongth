package capjjangdol.mallangkongth.domain.mypage;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;

@Getter@Setter
public class JoinForm {
    @NotBlank(message = "이메일은 필수 입력값입니다.")
    String email;

    @NotBlank(message = "비밀번호은 필수 입력값입니다.")
    String pw;

    @NotBlank(message = "이름은 필수 입력값입니다.")
    String name;

    Address address;
}
