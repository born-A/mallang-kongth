package capjjangdol.mallangkongth.domain.rearing;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class WaterBowl {
    @Id @GeneratedValue
    private String id;

    private Long remaining;

    private Long beforeEatingAmount;

    private Long currentEatingAmount;
    @Column(name = "setting_amount")
    private Long settingAmount;

    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime insertDate;

    public Long eatingAmount() {
        return this.settingAmount - this.remaining;
    }
}
