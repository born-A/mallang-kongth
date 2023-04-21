package capjjangdol.mallangkongth.domain.rearing;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class WaterBowl {
    @Id @GeneratedValue
    private Long id;

    private Long remaining;

    @Column(name = "setting_amount")
    private Long settingAmount;

    public Long eatingAmount() {
        return this.settingAmount - this.remaining;
    }
}
