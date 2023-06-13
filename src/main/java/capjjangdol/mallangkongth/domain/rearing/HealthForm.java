package capjjangdol.mallangkongth.domain.rearing;

import capjjangdol.mallangkongth.domain.mypage.Pet;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class HealthForm {
    private Long id;
    private String text;
    private String title;
    private String imageUrl;
}
