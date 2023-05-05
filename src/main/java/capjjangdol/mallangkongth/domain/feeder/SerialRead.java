package capjjangdol.mallangkongth.domain.feeder;

import capjjangdol.mallangkongth.repository.WaterLevelRepository;
import capjjangdol.mallangkongth.service.PetService;
import capjjangdol.mallangkongth.service.WaterLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;

//	값을 읽는 클래스로, 이는 Thread로 구현해야 한다.

public class SerialRead implements Runnable
{
    InputStream in;

    public SerialRead(InputStream in){this.in = in;}

    static WaterLevelRepository waterLevelRepository;

    @Override
    public void run()
    {
        byte[] buffer = new byte[5];
        int len = -1;



        try
        {
            //	buffer에 저장하고나서, 그 길이를 반환한다.
            while ((len = this.in.read(buffer)) > -1)
            {

                while(in.available() < 5){ // < 뒤에 숫자가 받아오는 값의 자릿수, 5은 무게센서에서 받아지는 자릿수
                    Thread.sleep(1);
                }

                String s = new String(buffer,0,len);
                if (len == 5 && s.charAt(0) == 'w'&& !s.contains("g")){//받아오는 값의 자릿수가 5자리일 때만 출력, 값 중간에 - 나오지 않도록 함
                    s = s.replaceAll("w", ""); //데이터 앞에 붙은 w 지우기
                    Integer.parseInt(s); //데이터 Int 값으로 변경
                    WaterLevel waterLevel = new WaterLevel();
                    waterLevel.setWaterLevel(Integer.parseInt(s));;
                    waterLevelRepository.save(waterLevel);
                } else if (len == 5 && s.charAt(0) == 'g' && !s.contains("w")) {
                    s = s.replaceAll("g", ""); //데이터 앞에 붙은 g 지우기
                    Integer.parseInt(s); //데이터 Int 값으로 변경
                    new HeftData(s);
                }
            }
        }
        catch (Exception e) {}
    }
}
