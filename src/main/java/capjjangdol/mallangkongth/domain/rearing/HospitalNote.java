package capjjangdol.mallangkongth.domain.rearing;

import capjjangdol.mallangkongth.domain.mypage.Pet;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class HospitalNote {
    @Id
    @GeneratedValue
    @Column(name = "HOSPITAL_NOTE_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PET_ID")
    private Pet pet;

    private String hospitalName;

    private LocalDateTime dateOfVisit;

    private Long Bill;

    private String memo;

    @Column(name = "IMAGE_URL")
    private String imageUrl;
}
