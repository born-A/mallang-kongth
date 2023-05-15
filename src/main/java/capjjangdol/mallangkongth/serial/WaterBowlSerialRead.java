package capjjangdol.mallangkongth.serial;

import capjjangdol.mallangkongth.domain.rearing.WaterBowl;
import capjjangdol.mallangkongth.domain.rearing.WaterNote;
import capjjangdol.mallangkongth.repository.WaterBowlRepository;
import capjjangdol.mallangkongth.repository.WaterNoteRepository;
import capjjangdol.mallangkongth.service.WaterBowlService;
import com.fazecast.jSerialComm.SerialPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.io.InputStream;

//	값을 읽는 클래스로, 이는 Thread로 구현해야 한다.
@Service
@Transactional
public class WaterBowlSerialRead {

    @Autowired
    WaterNoteRepository waterNoteRepository;

    @Autowired
    WaterBowlRepository waterBowlRepository;

    @Autowired
    WaterBowlService waterBowlService;

    @Autowired
    private TaskExecutor taskExecutor;

    private InputStream in = null;
    private boolean isOpen = false;

    @Scheduled(fixedRate = 10000)
    public void SerialRun(){
        SerialPort serialPort = SerialPort.getCommPort("COM7");
        isOpen = serialPort.openPort();
        if (isOpen) {
            System.out.println("open");
            in = serialPort.getInputStream();
            taskExecutor.execute(new WaterBowlSerialReadThread(in, waterNoteRepository, waterBowlRepository));
        } else {
            System.exit(0);
        }
    }
}