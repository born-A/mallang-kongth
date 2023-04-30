package capjjangdol.mallangkongth.domain.feeder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SerialRun implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        try {

            (new Serial()).connect("COM3");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
