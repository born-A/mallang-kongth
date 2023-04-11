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

        new SerialRead(in).run();
    }
}
