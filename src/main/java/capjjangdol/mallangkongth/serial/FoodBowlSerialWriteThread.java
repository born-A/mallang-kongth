package capjjangdol.mallangkongth.serial;

import com.fazecast.jSerialComm.SerialPort;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class FoodBowlSerialWriteThread implements Runnable {
    private final SerialPort serialPort;

    public FoodBowlSerialWriteThread(SerialPort serialPort){
        this.serialPort = serialPort;
    }

    @Override
    public void run(){
        //바이트로 변환하여 전송해야함
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.putInt(1);
        byte[] b = buffer.array();
        try {
            serialPort.writeBytes(b, b.length);
        } catch (Exception e) {}
    }
}
