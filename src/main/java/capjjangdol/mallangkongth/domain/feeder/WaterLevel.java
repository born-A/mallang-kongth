package capjjangdol.mallangkongth.domain.feeder;

import javax.persistence.Entity;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data //Getter, Setter 생성
@Entity //DB에 TABLE을 생성
public class WaterLevel {
    @GeneratedValue //번호 증가 전략
    @Id
    private Long id;
    private Integer waterLevel;

}


