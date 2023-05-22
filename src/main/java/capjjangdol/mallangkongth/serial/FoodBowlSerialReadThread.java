package capjjangdol.mallangkongth.serial;

import capjjangdol.mallangkongth.domain.rearing.FoodBowl;
import capjjangdol.mallangkongth.domain.rearing.FoodNote;
import capjjangdol.mallangkongth.repository.FoodBowlRepository;
import capjjangdol.mallangkongth.repository.FoodNoteRepository;

import java.io.InputStream;

public class FoodBowlSerialReadThread implements Runnable{
    private final InputStream in;
    private final FoodNoteRepository foodNoteRepository;
    private final FoodBowlRepository foodBowlRepository;

    public FoodBowlSerialReadThread(InputStream in, FoodNoteRepository foodNoteRepository, FoodBowlRepository foodBowlRepository) {
        this.in = in;
        this.foodNoteRepository = foodNoteRepository;
        this.foodBowlRepository = foodBowlRepository;
    }

    @Override
    public void run() {
        byte[] buffer = new byte[10];
        int len = -1;
        int foodAmount;
        int settingAmount;
        int beforeEatingAmount;
        int CurrentEatingAmount;
        try {
            while ((len = this.in.read(buffer)) > -1) {
                while(in.available() < 5){
                    //센서 값은 5글자로 넘어 오기 때문에 버퍼에 5글자가 채워졌는지 확인 하고 안들어 왔다면 스레드 멈추고 들어올때 까지 기다리기
                    Thread.sleep(1);
                }
                String s = new String(buffer,0,len);
                //h로 무게 값이 들어오는것을 확인 len == 5로 시리얼로 받은 데이터가 형식에 맞게 버퍼에 들어왔는지 확인
                if (len == 5 && s.charAt(0) == 'h' && !s.contains("w")) {
                    s = s.replaceAll("h", "");
                    FoodNote foodNote = new FoodNote();
                    foodNote.setAmount(Integer.parseInt(s));
                    foodNoteRepository.save(foodNote);
                    foodAmount = foodNoteRepository.findAmount().get(0);
                    settingAmount = foodBowlRepository.findSettingAmount().get(0);
                    beforeEatingAmount = foodBowlRepository.findBeforeEatingAmount().get(0);
                    CurrentEatingAmount = foodBowlRepository.findCurrentEatingAmount().get(0);
                    if(foodBowlRepository.findRemaining().get(0) < Integer.parseInt(s)){ // 급식기에 물 추가 했을때 foodBowl DB에 저장하는 코드
                        FoodBowl foodBowl = new FoodBowl();
                        foodBowl.setSettingAmount(Integer.parseInt(s));
                        foodBowl.setRemaining(Integer.parseInt(s));
                        foodBowl.setBeforeEatingAmount(CurrentEatingAmount); //물 증가 하기 전의 음수량
                        foodBowl.setCurrentEatingAmount(CurrentEatingAmount);
                        foodBowlRepository.save(foodBowl);
                    } else { // 급식기에 물 추가 없이 그대로 일떄 foodBowl DB에 저장하는 코드
                        FoodBowl foodBowl = new FoodBowl();
                        foodBowl.setSettingAmount(settingAmount);
                        foodBowl.setRemaining(foodAmount);
                        foodBowl.setBeforeEatingAmount(beforeEatingAmount);
                        foodBowl.setCurrentEatingAmount(settingAmount - foodAmount + beforeEatingAmount); //세팅된 물 - 현재 잔여량 + 이전 음수량
                        foodBowlRepository.save(foodBowl);
                    }
                }
            }
        } catch (Exception e) {}
    }
}
