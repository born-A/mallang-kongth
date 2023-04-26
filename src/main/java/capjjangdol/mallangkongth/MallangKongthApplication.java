package capjjangdol.mallangkongth;

import capjjangdol.mallangkongth.domain.rearing.FoodBowl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@SpringBootApplication
public class MallangKongthApplication {

	public static void main(String[] args) {
		SpringApplication.run(MallangKongthApplication.class, args);
	}

}
