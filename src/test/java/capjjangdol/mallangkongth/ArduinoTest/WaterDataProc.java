package capjjangdol.mallangkongth.ArduinoTest;

public class WaterDataProc {
    String recvData;

    public WaterDataProc(String recvData)
    {
        this.recvData = recvData.replace("w","");
        Print();
    }

    public void Print()
    {
        System.out.println("WaterDataProc : "+recvData);
    }
}
