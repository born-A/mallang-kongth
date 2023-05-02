package capjjangdol.mallangkongth.ArduinoTest;



public class Main {
    public static void main(String[] args)
    {
        try {

            (new Serial()).connect("COM5");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}