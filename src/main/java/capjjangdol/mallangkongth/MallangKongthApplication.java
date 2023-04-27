package capjjangdol.mallangkongth;

import capjjangdol.mallangkongth.domain.mypage.Member;
import capjjangdol.mallangkongth.domain.mypage.Orders;
import capjjangdol.mallangkongth.domain.mypage.RoleType;
import capjjangdol.mallangkongth.domain.rearing.FoodBowl;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class MallangKongthApplication {

	public static void main(String[] args) {
		SpringApplication.run(MallangKongthApplication.class, args);



	}
}
