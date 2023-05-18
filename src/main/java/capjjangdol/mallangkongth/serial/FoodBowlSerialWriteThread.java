package capjjangdol.mallangkongth.serial;

import com.fazecast.jSerialComm.SerialPort;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class FoodBowlSerialWriteThread implements Runnable {
    private final OutputStream out;

    public FoodBowlSerialWriteThread(OutputStream out){
        this.out = out;
    }

    @Override
    public void run(){
        while (true){
            try {
                out.write(1);
                Thread.sleep(500);
            } catch (Exception e) {}
        }
    }
}
