package capjjangdol.mallangkongth.serial;

import capjjangdol.mallangkongth.repository.FoodServingRepository;

import java.io.OutputStream;

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
        while (true){
            try {
                foodServingRepository.findFoodServingSize().get(0);
            } catch (Exception e) {}
        }
    }
}