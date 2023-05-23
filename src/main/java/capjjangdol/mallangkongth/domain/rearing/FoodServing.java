package capjjangdol.mallangkongth.domain.rearing;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import capjjangdol.mallangkongth.domain.rearing.FoodBowl;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class FoodServing {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private FoodBowl foodBowl;
    private Integer foodServingSize;

    @CreationTimestamp
    @Column(name = "water_insert_time")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime insertTime;
}
