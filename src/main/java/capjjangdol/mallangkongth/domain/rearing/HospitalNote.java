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
    @Column(name = "hospital_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    private String hospitalName;

    private LocalDateTime dateOfVisit;

    private Long Bill;

    private String memo;

    @Column(name = "image_url")
    private String imageUrl;
}
