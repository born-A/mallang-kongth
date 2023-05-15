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
            Thread.sleep(3000);
            while ((len = this.in.read(buffer)) > -1) {
                while(in.available() < 5){
                    Thread.sleep(1);
                }
                String s = new String(buffer,0,len);
                if (len == 5 && s.charAt(0) == 'w'&& !s.contains("h")) {
                    s = s.replaceAll("w", "");
                    WaterNote waterNote = new WaterNote();
                    waterNote.setAmount(Integer.parseInt(s));
                    waterNoteRepository.save(waterNote);
                    waterAmount = waterNoteRepository.findAmount().get(0);
                    settingAmount = waterBowlRepository.findSettingAmount().get(0);
                    beforeEatingAmount = waterBowlRepository.findBeforeEatingAmount().get(0);
                    CurrentEatingAmount = waterBowlRepository.findCurrentEatingAmount().get(0);
                    if(waterBowlRepository.findRemaining().get(0) < Integer.parseInt(s)){
                        WaterBowl waterBowl = new WaterBowl();
                        waterBowl.setSettingAmount(Integer.parseInt(s));
                        waterBowl.setRemaining(Integer.parseInt(s));
                        waterBowl.setBeforeEatingAmount(CurrentEatingAmount);
                        waterBowl.setCurrentEatingAmount(CurrentEatingAmount);
                        waterBowlRepository.save(waterBowl);
                    } else {
                        WaterBowl waterBowl = new WaterBowl();
                        waterBowl.setSettingAmount(settingAmount);
                        waterBowl.setRemaining(waterAmount);
                        waterBowl.setBeforeEatingAmount(beforeEatingAmount);
                        waterBowl.setCurrentEatingAmount(settingAmount - waterAmount + beforeEatingAmount);
                        waterBowlRepository.save(waterBowl);
                    }
                }
            }
        } catch (Exception e) {}
    }
}
