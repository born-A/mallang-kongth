package capjjangdol.mallangkongth.serial;

import capjjangdol.mallangkongth.domain.rearing.WaterBowl;
import capjjangdol.mallangkongth.domain.rearing.WaterNote;
import capjjangdol.mallangkongth.repository.WaterBowlRepository;
import capjjangdol.mallangkongth.repository.WaterNoteRepository;

import java.io.InputStream;

public class WaterBowlSerialReadThread implements Runnable{
    private final InputStream in;
    private final WaterNoteRepository waterNoteRepository;
    private final WaterBowlRepository waterBowlRepository;

    public WaterBowlSerialReadThread(InputStream in, WaterNoteRepository waterNoteRepository, WaterBowlRepository waterBowlRepository) {
        this.in = in;
        this.waterNoteRepository = waterNoteRepository;
        this.waterBowlRepository = waterBowlRepository;
    }

    @Override
    public void run() {
        byte[] buffer = new byte[10];
        int len = -1;
        int waterAmount;
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
                //w로 물 값이 들어오는것을 확인 len == 5로 시리얼로 받은 데이터가 형식에 맞게 버퍼에 들어왔는지 확인
                if (len == 5 && s.charAt(0) == 'w' && !s.contains("h")) {
                    s = s.replaceAll("w", "");
                    WaterNote waterNote = new WaterNote();
                    waterNote.setAmount(Integer.parseInt(s));
                    waterNoteRepository.save(waterNote);
                    waterAmount = waterNoteRepository.findAmount().get(0);
                    settingAmount = waterBowlRepository.findSettingAmount().get(0);
                    beforeEatingAmount = waterBowlRepository.findBeforeEatingAmount().get(0);
                    CurrentEatingAmount = waterBowlRepository.findCurrentEatingAmount().get(0);
                    if(waterBowlRepository.findRemaining().get(0) < Integer.parseInt(s)){ // 급수기에 물 추가 했을때 waterBowl DB에 저장하는 코드
                        WaterBowl waterBowl = new WaterBowl();
                        waterBowl.setSettingAmount(Integer.parseInt(s));
                        waterBowl.setRemaining(Integer.parseInt(s));
                        waterBowl.setBeforeEatingAmount(CurrentEatingAmount); //물 증가 하기 전의 음수량
                        waterBowl.setCurrentEatingAmount(CurrentEatingAmount);
                        waterBowlRepository.save(waterBowl);
                    } else { // 급수기에 물 추가 없이 그대로 일떄 waterBowl DB에 저장하는 코드
                        WaterBowl waterBowl = new WaterBowl();
                        waterBowl.setSettingAmount(settingAmount);
                        waterBowl.setRemaining(waterAmount);
                        waterBowl.setBeforeEatingAmount(beforeEatingAmount);
                        waterBowl.setCurrentEatingAmount(settingAmount - waterAmount + beforeEatingAmount); //세팅된 물 - 현재 잔여량 + 이전 음수량
                        waterBowlRepository.save(waterBowl);
                    }
                }
            }
        } catch (Exception e) {}
    }
}
