package capjjangdol.mallangkongth.serial;

import capjjangdol.mallangkongth.dto.FoodServingTimeDto;
import capjjangdol.mallangkongth.repository.FoodServingRepository;
import capjjangdol.mallangkongth.repository.FoodServingTimeRepository;

import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.List;

public class FoodBowlSerialWriteThread implements Runnable {
    private final OutputStream out;
    private final FoodServingRepository foodServingRepository;

    private final FoodServingTimeRepository foodServingTimeRepository;

    public FoodBowlSerialWriteThread(OutputStream out, FoodServingRepository foodServingRepository, FoodServingTimeRepository foodServingTimeRepository){
        this.out = out;
        this.foodServingRepository = foodServingRepository;
        this.foodServingTimeRepository = foodServingTimeRepository;
    }

    @Override
    public void run(){
        int temp = -1;
        LocalDateTime insertTime;
        LocalDateTime lastInsertTime = LocalDateTime.parse("1999-12-31T23:59:59.999");
        while (true){
            try {
                insertTime = foodServingRepository.findInsertTime().get(0);
                if( lastInsertTime.isBefore(insertTime)) {
                    out.write(foodServingRepository.findFoodServingSize().get(0));
                    lastInsertTime = insertTime;
                }
                List<FoodServingTimeDto> timeDtoList = foodServingTimeRepository.findFoodServingTime();
                for (FoodServingTimeDto timeDto : timeDtoList){
                    if(timeDto.getServingTime().equals(LocalDateTime.now())){
                        out.write(timeDto.getServingSize());
                    }
                }
            } catch (Exception e) {}
        }
    }
}