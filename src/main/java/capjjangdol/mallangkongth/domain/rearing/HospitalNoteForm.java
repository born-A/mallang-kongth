package capjjangdol.mallangkongth.domain.rearing;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class HospitalNoteForm {
    private Long id;
    //병원이름
    private String hospitalName;
    //방문날짜
    private LocalDateTime dateOfVisit;
    //병원비
    private Long Bill;
    //메모
    private String memo;
    //이미지 url
    private String imageUrl;
}
