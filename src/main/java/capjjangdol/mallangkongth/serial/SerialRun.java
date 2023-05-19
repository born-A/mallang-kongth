package capjjangdol.mallangkongth.serial;

import capjjangdol.mallangkongth.repository.FoodBowlRepository;
import capjjangdol.mallangkongth.repository.FoodNoteRepository;
import capjjangdol.mallangkongth.repository.WaterBowlRepository;
import capjjangdol.mallangkongth.repository.WaterNoteRepository;
import capjjangdol.mallangkongth.service.WaterBowlService;
import com.fazecast.jSerialComm.SerialPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//   값을 읽는 클래스로, 이는 Thread로 구현해야 한다.
@Transactional
@Service
public class SerialRun {

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
    private OutputStream foodBowlOut = null;
    private boolean waterBowlIsOpen = false;
    private boolean foodBowlIsOpen = false;

    @PostConstruct
    public void SerialRun(){
        //스레드 풀은 항상 3개의 스레드를 가지고 최대 10개의 스레드를 가질 수 있습니다 대기열에는 최대 20개의 작업이 들어갈 수 있습니다
        executor = new ThreadPoolExecutor(3,10,0L, TimeUnit.MICROSECONDS, new LinkedBlockingDeque<Runnable>(20));

        SerialPort waterBowlSerialPort = SerialPort.getCommPort("COM7"); //급수기 포트 번호 입력
        waterBowlIsOpen = waterBowlSerialPort.openPort(); //포트 열기
        SerialPort foodBowlSerialPort = SerialPort.getCommPort("COM8"); //급식기 포트 번호 입력
        foodBowlIsOpen = foodBowlSerialPort.openPort(); //포트 열기

/*
        WaterBowl waterBowl = new WaterBowl(); //초기 데이터 넣기
        waterBowl.setSettingAmount(0);
        waterBowl.setRemaining(0);
        waterBowl.setBeforeEatingAmount(0);
        waterBowl.setCurrentEatingAmount(0);
        waterBowlRepository.save(waterBowl);

 */

        if (waterBowlIsOpen && foodBowlIsOpen) { // 급수기 급식기 모두 연결 되어야 함
            System.out.println("open");
            waterBowlIn = waterBowlSerialPort.getInputStream(); //급수기 수신
            foodBowlIn = foodBowlSerialPort.getInputStream(); //급식기 수신
            foodBowlOut = foodBowlSerialPort.getOutputStream(); //급식기 송신
            executor.execute(new WaterBowlSerialReadThread(waterBowlIn, waterNoteRepository, waterBowlRepository)); //급수기 수신 작업을 하는 스레드 실행
            executor.execute(new FoodBowlSerialReadThread(foodBowlIn , foodNoteRepository, foodBowlRepository)); //급식기 수신 작업을 하는 스레드 실행
            executor.execute(new FoodBowlSerialWriteThread(foodBowlOut));
        } else {
            System.exit(0);
        }
    }
}