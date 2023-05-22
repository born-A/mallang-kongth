package capjjangdol.mallangkongth.serial;

import capjjangdol.mallangkongth.repository.FoodServingRepository;

import java.io.OutputStream;
import java.time.LocalDateTime;

public class FoodBowlSerialWriteThread implements Runnable {
    private final OutputStream out;
    private final FoodServingRepository foodServingRepository;

    public FoodBowlSerialWriteThread(OutputStream out, FoodServingRepository foodServingRepository){
        this.out = out;
        this.foodServingRepository = foodServingRepository;
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
            } catch (Exception e) {}
        }
    }
}