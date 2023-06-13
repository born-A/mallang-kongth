package capjjangdol.mallangkongth.serial;

import capjjangdol.mallangkongth.dto.FoodServingTimeDto;
import capjjangdol.mallangkongth.repository.FoodServingRepository;
import capjjangdol.mallangkongth.repository.FoodServingTimeRepository;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
        LocalTime localTime;
        String localTime2;
        String temp2 = null;
        boolean check = false;
        LocalDateTime lastInsertTime = LocalDateTime.parse("1999-12-31T23:59:59.999");
        while (true){
            try {
                insertTime = foodServingRepository.findInsertTime().get(0);
                if( lastInsertTime.isBefore(insertTime)) {
                    int send1;
                    send1 = foodServingRepository.findFoodServingSize().get(0);
                    String send2 = String.valueOf(send1);
                    out.write(send2.getBytes());
                    System.out.println("입력");
                    lastInsertTime = insertTime;
                }
                List<FoodServingTimeDto> timeDtoList = foodServingTimeRepository.findFoodServingTime();
                for (FoodServingTimeDto timeDto : timeDtoList){
                    localTime = LocalTime.now();
                    localTime2 = localTime.format(DateTimeFormatter.ofPattern("HH:mm")).toString(); //비교를 위해 string으로 변환
                  if(timeDto.getServingTime().toString().compareTo(localTime2) == 0 && check == false){ //check는 그 시간대에 한번만 동작하기 위해 넣음
                      int send1 = timeDto.getServingSize();
                      String send2 = String.valueOf(send1);
                        out.write(send2.getBytes());
                        temp2 = localTime2;
                        check = true;
                    }
                  if(temp2.compareTo(localTime2) != 0){
                      check = true;
                  }
                }
            } catch (Exception e) {}
        }
    }
}