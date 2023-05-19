package capjjangdol.mallangkongth.domain.rearing;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class FoodBowl {

    @Id
    @GeneratedValue
    private Long id;
    private String productCode;
    private Integer  remaining;
    private Integer beforeEatingAmount;
    private Integer currentEatingAmount;
    @Column(name = "setting_amount")
    private Integer settingAmount;

    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime insertDate;
}
