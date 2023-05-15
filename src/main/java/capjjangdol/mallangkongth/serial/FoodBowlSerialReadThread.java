package capjjangdol.mallangkongth.serial;

import capjjangdol.mallangkongth.domain.rearing.WaterBowl;
import capjjangdol.mallangkongth.domain.rearing.WaterNote;
import capjjangdol.mallangkongth.repository.WaterBowlRepository;
import capjjangdol.mallangkongth.repository.WaterNoteRepository;

import java.io.InputStream;
// food bowl에 맞춰 수정 필요
public class FoodBowlSerialReadThread implements Runnable{
    private final InputStream in;
    private final WaterNoteRepository waterNoteRepository;
    private final WaterBowlRepository waterBowlRepository;

    public FoodBowlSerialReadThread(InputStream in, WaterNoteRepository waterNoteRepository, WaterBowlRepository waterBowlRepository) {
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
                    Thread.sleep(1);
                }
                String s = new String(buffer,0,len);
                if (len == 5 && s.charAt(0) == 'h'&& !s.contains("w")) {
                    s = s.replaceAll("h", "");
                    WaterNote waterNote = new WaterNote();
                    waterNote.setAmount(Integer.parseInt(s));
                    waterNoteRepository.save(waterNote);
                }
            }
        } catch (Exception e) {}
    }
}
