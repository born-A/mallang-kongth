package capjjangdol.mallangkongth.domain.feeder;


public class WaterData {
    String recvData;

    public WaterData(String recvData)
    {
        this.recvData = recvData.replace("w","");
        Print();
    }

    public void Print()
    {
        System.out.println("WaterDataProc : "+recvData);
    }
}