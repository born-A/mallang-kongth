package capjjangdol.mallangkongth.serial;

import capjjangdol.mallangkongth.domain.rearing.WaterBowl;
import capjjangdol.mallangkongth.repository.FoodBowlRepository;
import capjjangdol.mallangkongth.repository.FoodNoteRepository;
import capjjangdol.mallangkongth.repository.WaterBowlRepository;
import capjjangdol.mallangkongth.repository.WaterNoteRepository;
import capjjangdol.mallangkongth.service.WaterBowlService;
import com.fazecast.jSerialComm.SerialPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//   값을 읽는 클래스로, 이는 Thread로 구현해야 한다.
@Transactional
@Service
public class SerialRead {

    @Autowired
    WaterNoteRepository waterNoteRepository;

    @Autowired
    WaterBowlRepository waterBowlRepository;

    @Autowired
    WaterBowlService waterBowlService;

    @Autowired
    FoodNoteRepository foodNoteRepository;

    @Autowired
    FoodBowlRepository foodBowlRepository;

    private Executor executor;
    private InputStream waterBowlIn = null;
    private InputStream foodBowlIn = null;
    private boolean waterBowlIsOpen = false;
    private boolean foodBowlIsOpen = false;

    @PostConstruct
    public void SerialRun(){

        executor = new ThreadPoolExecutor(2,2,0L, TimeUnit.MICROSECONDS, new LinkedBlockingDeque<Runnable>(5));

        SerialPort waterBowlSerialPort = SerialPort.getCommPort("COM7");
        waterBowlIsOpen = waterBowlSerialPort.openPort();
        SerialPort foodBowlSerialPort = SerialPort.getCommPort("COM8");
        foodBowlIsOpen = foodBowlSerialPort.openPort();

/*
        WaterBowl waterBowl = new WaterBowl(); //초기 데이터 넣기
        waterBowl.setSettingAmount(0);
        waterBowl.setRemaining(0);
        waterBowl.setBeforeEatingAmount(0);
        waterBowl.setCurrentEatingAmount(0);
        waterBowlRepository.save(waterBowl);

 */

        if (waterBowlIsOpen && foodBowlIsOpen) {
            System.out.println("open");
            waterBowlIn = waterBowlSerialPort.getInputStream();
            foodBowlIn = foodBowlSerialPort.getInputStream();
            executor.execute(new WaterBowlSerialReadThread(waterBowlIn, waterNoteRepository, waterBowlRepository));
            executor.execute(new FoodBowlSerialReadThread(foodBowlIn , foodNoteRepository, foodBowlRepository));
        } else {
            System.exit(0);
        }
    }
}