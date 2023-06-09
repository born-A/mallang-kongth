package capjjangdol.mallangkongth.ArduinoTest;

import java.io.IOException;
import java.io.InputStream;

//	값을 읽는 클래스로, 이는 Thread로 구현해야 한다.
public class SerialRead implements Runnable
{
    InputStream in;

    public SerialRead(InputStream in){this.in = in;}

    @Override
    public void run()
    {
        byte[] buffer = new byte[5];
        int len = -1;


        try
        {
            //	buffer에 저장하고나서, 그 길이를 반환한다.
            while ((len = this.in.read(buffer)) > -1)
            {

                while(in.available() < 4){ // < 뒤에 숫자가 받아오는 값의 자릿수, 4은 무게센서에서 받아지는 자릿수
                    Thread.sleep(1);
                }

                String s = new String(buffer,0,len);
                if (len == 4 && s.charAt(0) == 'w'&& !s.contains("g")){//받아오는 값의 자릿수가 3자리일 때만 출력, 값 중간에 - 나오지 않도록 함
                    new WaterDataProc(s);
                } else if (len == 4 && s.charAt(0) == 'g' && !s.contains("w")) {
                    new DataProc(s);
                }
            }
        }
        catch (Exception e) {}
    }
}
