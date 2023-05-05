package capjjangdol.mallangkongth.ArduinoTest;

import capjjangdol.mallangkongth.domain.feeder.WaterLevel;
import capjjangdol.mallangkongth.repository.WaterLevelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.InputStream;

//	값을 읽는 클래스로, 이는 Thread로 구현해야 한다.
@RequiredArgsConstructor
@Service
public class SerialRead implements Runnable
{
    InputStream in;

    public SerialRead(InputStream in){this.in = in;}

    @Override
    public void run()
    {
        byte[] buffer = new byte[5];
        int len = -1;

        final WaterLevelRepository waterLevelRepository = null;

        try
        {
            //	buffer에 저장하고나서, 그 길이를 반환한다.
            while ((len = this.in.read(buffer)) > -1)
            {

                while(in.available() < 5){ // < 뒤에 숫자가 받아오는 값의 자릿수, 4은 무게센서에서 받아지는 자릿수
                    Thread.sleep(1);
                }

                String s = new String(buffer,1,len);
                if (len == 5 && s.charAt(0) == 'w'&& !s.contains("g")){//받아오는 값의 자릿수가 3자리일 때만 출력, 값 중간에 - 나오지 않도록 함
                    new WaterData(s);
                } else if (len == 5 && s.charAt(0) == 'g' && !s.contains("w")) {
                    WaterLevel waterLevel = new WaterLevel();
                    waterLevel.setWaterLevel(Integer.valueOf(s));
                    waterLevelRepository.save(waterLevel);
                }
            }
        }
        catch (Exception e) {}
    }
}
