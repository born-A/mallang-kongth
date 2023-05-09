package capjjangdol.mallangkongth.ArduinoTest;

import java.io.IOException;
import java.io.OutputStream;

public class SerialWrite implements Runnable
{
    OutputStream out;

    public SerialWrite(OutputStream out) {this.out = out;}

    @Override
    public void run()
    {
        int c = 0;

        try
        {
            while ((c = System.in.read()) > -1)
            {
                out.write(c); //시리얼 보내는 코드
            }
        } catch (IOException e) {e.printStackTrace();}
    }
}