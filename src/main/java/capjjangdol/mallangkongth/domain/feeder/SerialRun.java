package capjjangdol.mallangkongth.domain.feeder;

import com.fazecast.jSerialComm.SerialPort;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class SerialRun implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        try {

            // COM6 포트를 가져온다.
            SerialPort serialPort = SerialPort.getCommPort("COM3");

            // 시리얼 포트를 오픈한다.
            boolean isOpen = serialPort.openPort();


            if (isOpen) {
                // 입력을 받기 위해 InputStream을 가져온다.
                InputStream in = serialPort.getInputStream();
                new Thread(new SerialRead(in)).start();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
