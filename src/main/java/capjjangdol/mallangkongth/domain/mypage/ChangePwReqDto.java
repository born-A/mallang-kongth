package capjjangdol.mallangkongth.domain.mypage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChangePwReqDto {
    private String email;
    private String exPw;
    private String newPw;
}
