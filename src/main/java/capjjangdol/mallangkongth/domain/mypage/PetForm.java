package capjjangdol.mallangkongth.domain.mypage;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class PetForm {
    @NotEmpty(message = "반려동물 이름은 필수 입력 사항입니다.")
    private String name;
}
