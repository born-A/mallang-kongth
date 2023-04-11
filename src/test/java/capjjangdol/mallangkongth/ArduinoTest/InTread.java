package capjjangdol.mallangkongth.ArduinoTest;

import capjjangdol.mallangkongth.ArduinoTest.SerialRead;

import java.io.IOException;
import java.io.InputStream;

public class InTread extends Thread{
    InputStream in;
    public InTread(InputStream in){
        this.in = in;
    }
    public void run(){

        try {
            while(in.available() < 4){
                Thread.sleep(2);
            }
            new SerialRead(in).run();
        }
        catch (Exception e) {}
    }
}
