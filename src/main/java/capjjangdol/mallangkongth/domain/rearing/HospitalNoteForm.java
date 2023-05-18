package capjjangdol.mallangkongth.domain.rearing;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class HospitalNoteForm {
    private Long id;
    private String hospitalName;
    private String dateOfVisit;
    private Long Bill;
    private String memo;
    private String imageUrl;
}
