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
        while(true){
            try {
                if (!(in.available() < 4)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        new SerialRead(in);
    }
}
