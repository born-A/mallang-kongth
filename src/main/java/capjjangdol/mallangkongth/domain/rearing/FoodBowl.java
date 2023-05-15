package capjjangdol.mallangkongth.domain.rearing;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FoodBowl {

    @Id @GeneratedValue
    private Long id;

    private Integer  remaining;

    @Column(name = "setting_amount")
    private Integer settingAmount;


    public Integer  eatingAmount() {
        return this.settingAmount - this.remaining;
    }

    public Integer  getEatingAmount(){
        return eatingAmount();
    }
    public Integer  getRemaining() {
        return remaining;
    }

    public void setRemaining(Integer  remaining) {
        this.remaining = remaining;
    }

    public Integer  getSettingAmount() {
        return settingAmount;
    }

    public void setSettingAmount(Integer  settingAmount) {
        this.settingAmount = settingAmount;
    }

}
