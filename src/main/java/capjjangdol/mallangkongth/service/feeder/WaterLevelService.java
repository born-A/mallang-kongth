package capjjangdol.mallangkongth.service.feeder;

import capjjangdol.mallangkongth.domain.feeder.SerialRead;
import capjjangdol.mallangkongth.domain.feeder.WaterLevel;
import capjjangdol.mallangkongth.repository.WaterLevelRepository;
import com.fazecast.jSerialComm.SerialPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.InputStream;

@Service
public class WaterLevelService {

    @Autowired
    private WaterLevelRepository waterLevelRepository;

    @Transactional
    @PostConstruct
    public void saveWaterLevel() {
        try {
            // COM3 포트를 가져온다.
            SerialPort serialPort = SerialPort.getCommPort("COM3");

            // 시리얼 포트를 오픈한다.
            boolean isOpen = serialPort.openPort();


            if (isOpen) {
                // 입력을 받기 위해 InputStream을 가져온다.
                InputStream in = serialPort.getInputStream();
                Thread thread = new Thread(() -> {
                    // 스레드 내에서 수행하는 DB 작업
                    WaterLevel waterLevel = new WaterLevel();
                    waterLevel.setWaterLevel(0);
                    waterLevelRepository.save(waterLevel);
                });
                thread.start();
            } else {
                System.exit(0); // 포트가 연결 안된경우 스프링부트 종료시킴
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
