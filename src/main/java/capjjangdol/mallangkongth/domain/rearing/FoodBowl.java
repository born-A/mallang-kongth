package capjjangdol.mallangkongth.domain.rearing;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FoodBowl {

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
