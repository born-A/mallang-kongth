package capjjangdol.mallangkongth.ArduinoTest;

public class WaterData {
    int num;

    public WaterData(int num)
    {
        this.num = num;
        Print();
    }

    public void Print()
    {
        System.out.println("WaterData : "+num);
    }
}
