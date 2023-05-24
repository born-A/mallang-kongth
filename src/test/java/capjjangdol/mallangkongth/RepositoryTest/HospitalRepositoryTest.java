package capjjangdol.mallangkongth.RepositoryTest;


import capjjangdol.mallangkongth.repository.HospitalRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class HospitalRepositoryTest {
@Autowired
    HospitalRepository hospitalRepository;
@Test
@Rollback(value = false)
    public void Delete() {
        hospitalRepository.deleteById(2); // Delete
    }
}