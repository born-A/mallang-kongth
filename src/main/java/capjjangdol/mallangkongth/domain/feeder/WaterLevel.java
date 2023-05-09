package capjjangdol.mallangkongth.domain.feeder;

import javax.persistence.Entity;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class WaterLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int waterLevel;

    // 생성자, getter, setter, toString 생략
}


