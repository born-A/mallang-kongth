package capjjangdol.mallangkongth.ArduinoTest;

public class DataProc
{
    String recvData;

    public DataProc(String recvData)
    {
        this.recvData = recvData.replace("g","");
        Print();
    }

    public void Print()
    {
        System.out.println("HeftData : "+recvData);
    }
}