package capjjangdol.mallangkongth;

import capjjangdol.mallangkongth.domain.feeder.Serial;
import capjjangdol.mallangkongth.domain.mypage.Member;
import capjjangdol.mallangkongth.domain.mypage.Orders;
import capjjangdol.mallangkongth.domain.mypage.RoleType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@SpringBootApplication
public class MallangKongthApplication {

	public static void main(String[] args) {

		SpringApplication.run(MallangKongthApplication.class, args);


		try {

			(new Serial()).connect("COM3");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
