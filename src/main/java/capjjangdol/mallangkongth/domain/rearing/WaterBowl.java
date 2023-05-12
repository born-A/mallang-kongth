package capjjangdol.mallangkongth.domain.rearing;

import lombok.Getter;
import lombok.Setter;
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

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime insertDate;

    public Long eatingAmount() {
        return this.settingAmount - this.remaining;
    }
}
