package capjjangdol.mallangkongth.domain.mypage;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter
public class PetForm {
    @NotEmpty(message = "반려동물 이름은 필수 입력 사항입니다.")
    private String name;


    private String birthday;

    private double weight;

    private boolean gender; // 성별 (true: 남성, false: 여성)

    private String breed;
}
