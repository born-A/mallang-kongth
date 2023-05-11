package capjjangdol.mallangkongth;

import capjjangdol.mallangkongth.domain.mypage.Member;
import capjjangdol.mallangkongth.domain.mypage.Orders;
import capjjangdol.mallangkongth.domain.mypage.RoleType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class MallangKongthApplication {

	public static void main(String[] args) {
		SpringApplication.run(MallangKongthApplication.class, args);
	}
}
