package capjjangdol.mallangkongth.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
public class FoodServingTimeDto {
    private Long id;
    private LocalTime servingTime;
    private Integer servingSize;

    public FoodServingTimeDto (Long id, LocalTime servingTime, Integer servingSize){
        this.servingSize = servingSize;
        this.servingTime = servingTime;
        this.id = id;
    }
}
