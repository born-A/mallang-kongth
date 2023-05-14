package capjjangdol.mallangkongth.serial;

import capjjangdol.mallangkongth.domain.rearing.WaterBowl;
import capjjangdol.mallangkongth.domain.rearing.WaterNote;
import capjjangdol.mallangkongth.repository.WaterBowlRepository;
import capjjangdol.mallangkongth.repository.WaterNoteRepository;
import com.fazecast.jSerialComm.SerialPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.io.InputStream;

//	값을 읽는 클래스로, 이는 Thread로 구현해야 한다.
@Service
@Transactional
public class WaterBowlSerialRead
{
    @Autowired
    WaterNoteRepository waterNoteRepository;
    @Autowired
    WaterBowlRepository waterBowlRepository;

    InputStream in = null;
    boolean isOpen = false;
    @PostConstruct
    public void SerialRun(){
        WaterBowl waterBowl1 = new WaterBowl();


        SerialPort serialPort = SerialPort.getCommPort("COM7"); //본인 포트 번호로 수정하고 실행해야함
        // 시리얼 포트를 오픈한다.
        isOpen = serialPort.openPort();
        if (isOpen) {
            System.out.println("open");
            // 입력을 받기 위해 InputStream을 가져온다.
            in = serialPort.getInputStream();
            Thread thread = new Thread(() -> {
                byte[] buffer = new byte[10];
                int len = -1;
                try
                {
                    //   buffer에 저장하고나서, 그 길이를 반환한다.
                    while ((len = this.in.read(buffer)) > -1)
                    {
                        while(in.available() < 5){ // < 뒤에 숫자가 받아오는 값의 자릿수, 5은 무게센서에서 받아지는 자릿수
                            Thread.sleep(1);
                        }
                        String s = new String(buffer,0,len);
                        if (len == 5 && s.charAt(0) == 'w'&& !s.contains("h")) {//받아오는 값의 자릿수가 5자리일 때만 출력, 값 중간에 - 나오지 않도록 함
                            s = s.replaceAll("w", ""); //데이터 앞에 붙은 w 지우기
                            WaterNote waterNote = new WaterNote();
                            waterNote.setAmount(Integer.parseInt(s)); //int 값으로 변환하여 넣기
                            waterNoteRepository.save(waterNote);
                            if(waterBowlRepository.findLatestRemaining()< Integer.parseInt(s)){
                                WaterBowl waterBowl = new WaterBowl();
                                waterBowl.setSettingAmount(Integer.parseInt(s));
                                waterBowl.setRemaining(Integer.parseInt(s));
                                waterBowl.setBeforeEatingAmount(waterBowlRepository.findLatestCurrentEatingAmount());
                                waterBowl.setCurrentEatingAmount(waterBowlRepository.findLatestCurrentEatingAmount());
                                waterBowlRepository.save(waterBowl);
                            }
                        }
                    }
                }
                catch (Exception e) {}
            });
            thread.start();

        } else {
            System.exit(0);
        }

    }

}