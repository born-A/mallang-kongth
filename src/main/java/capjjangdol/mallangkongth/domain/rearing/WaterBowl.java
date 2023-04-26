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

    @Column(name = "SETTING_AMOUNT")
    private Long settingAmount;

    public Long eatingAmount() {
        return this.settingAmount - this.remaining;
    }

    public Long getRemaining() {
        return remaining;
    }

    public void setRemaining(Long remaining) {
        this.remaining = remaining;
    }

    public Long getSettingAmount() {
        return settingAmount;
    }

    public void setSettingAmount(Long settingAmount) {
        this.settingAmount = settingAmount;
    }
}
