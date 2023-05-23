package capjjangdol.mallangkongth.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FoodServingTimeDto {
    private Long id;
    private LocalDateTime servingTime;
    private Integer servingSize;

    public FoodServingTimeDto (Long id, LocalDateTime servingTime, Integer servingSize){
        this.servingSize = servingSize;
        this.servingTime = servingTime;
        this.id = id;
    }
}
