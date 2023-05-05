package capjjangdol.mallangkongth.ArduinoTest;

import capjjangdol.mallangkongth.domain.feeder.SerialRead;
import capjjangdol.mallangkongth.domain.feeder.WaterLevel;
import capjjangdol.mallangkongth.repository.WaterLevelRepository;
import com.fazecast.jSerialComm.SerialPort;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;

public class SerialRun  {
    public static void main(String[] args) {
        try {
            // COM3 포트를 가져온다.
            SerialPort serialPort = SerialPort.getCommPort("COM3");

            // 시리얼 포트를 오픈한다.
            boolean isOpen = serialPort.openPort();

            if (isOpen) {
                // 입력을 받기 위해 InputStream을 가져온다.
                InputStream in = serialPort.getInputStream();
                new Thread(new SerialRead(in)).start();

            } else {
                System.out.println("not open");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}