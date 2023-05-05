package capjjangdol.mallangkongth.ArduinoTest;

import javax.persistence.Entity;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data //Getter, Setter 생성
@Entity //DB에 TABLE을 생성
public class WaterLevel {
    @GeneratedValue(strategy = GenerationType.IDENTITY) //번호 증가 전략
    @Id
    private Long id;
    private Integer waterLevel;
    private LocalDateTime createTime;

    @PrePersist
    public void createTime(){
        this.createTime = LocalDateTime.now();
    }
}


