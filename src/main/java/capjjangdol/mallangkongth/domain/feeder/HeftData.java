package capjjangdol.mallangkongth.domain.feeder;

public class HeftData {
    String recvData;

    public HeftData(String recvData)
    {
        this.recvData = recvData.replace("g","");
        Print();
    }

    public void Print()
    {
        System.out.println("DataProc : "+recvData);
    }
}
