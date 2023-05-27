package capjjangdol.mallangkongth.domain.mypage;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter@Setter
public class JoinForm {
    String email;
    String pw;
    String name;
    Address address;
}
