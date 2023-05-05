package capjjangdol.mallangkongth.ArduinoTest;

public class HeftData
{
    String recvData;

    public HeftData(String recvData)
    {
        this.recvData = recvData.replace("g","");
        Print();
    }

    public void Print()
    {
        System.out.println("HeftData : "+recvData);
    }
}