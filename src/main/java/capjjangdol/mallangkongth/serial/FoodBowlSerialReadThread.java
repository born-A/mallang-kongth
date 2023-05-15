package capjjangdol.mallangkongth.serial;

import capjjangdol.mallangkongth.domain.rearing.FoodBowl;
import capjjangdol.mallangkongth.domain.rearing.FoodNote;
import capjjangdol.mallangkongth.repository.FoodBowlRepository;
import capjjangdol.mallangkongth.repository.FoodNoteRepository;

import java.io.InputStream;
// food bowl에 맞춰 수정 필요
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
        try {
            while ((len = this.in.read(buffer)) > -1) {
                while(in.available() < 5){
                    Thread.sleep(1);
                }
                String s = new String(buffer,0,len);
                if (len == 5 && s.charAt(0) == 'h'&& !s.contains("w")) {
                    s = s.replaceAll("h", "");
                    FoodNote foodNote = new FoodNote();
                    foodNoteRepository.save(foodNote);
                }
            }
        } catch (Exception e) {}
    }
}
