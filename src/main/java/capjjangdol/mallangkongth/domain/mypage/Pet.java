package capjjangdol.mallangkongth.domain.mypage;

import capjjangdol.mallangkongth.domain.rearing.HospitalNote;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Pet {
    @Id
    @GeneratedValue
    @Column(name = "pet_id")
    private Long id;

    @Column(name = "pet_name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "birthday")
    private String birthday;

    private double weight;

    private boolean Gender; // 성별 (true: 남성, false: 여성)

    private String breed;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HospitalNote> hospitalNoteList = new ArrayList<>();

}
