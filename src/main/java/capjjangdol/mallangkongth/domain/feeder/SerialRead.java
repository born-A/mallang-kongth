package capjjangdol.mallangkongth.domain.feeder;

import capjjangdol.mallangkongth.repository.WaterLevelRepository;
import com.fazecast.jSerialComm.SerialPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.InputStream;

//	값을 읽는 클래스로, 이는 Thread로 구현해야 한다.
@Service
public class SerialRead
{
    @Autowired
    private WaterLevelRepository waterLevelRepository;

    InputStream in = null;
    @Transactional
    @PostConstruct
    public void SerialRun(){
        SerialPort serialPort = SerialPort.getCommPort("COM3");
        // 시리얼 포트를 오픈한다.
        boolean isOpen = serialPort.openPort();
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
                        if (len == 5 && s.charAt(0) == 'w'&& !s.contains("h")){//받아오는 값의 자릿수가 5자리일 때만 출력, 값 중간에 - 나오지 않도록 함
                            s = s.replaceAll("w", ""); //데이터 앞에 붙은 w 지우기
                            WaterLevel waterLevel = new WaterLevel();
                            waterLevel.setWaterLevel(Integer.parseInt(s)); //int 값으로 변환하여 넣기
                            waterLevelRepository.save(waterLevel);

                        } else if (len == 5 && s.charAt(0) == 'h' && !s.contains("w")) {
                            s = s.replaceAll("h", ""); //데이터 앞에 붙은 h 지우기
                            Integer.parseInt(s); //데이터 Int 값으로 변경
                            new HeftData(s);
                        }
                    }
                }
                catch (Exception e) {}
            });
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }

        } else {
            System.exit(0);
        }

    }

}
