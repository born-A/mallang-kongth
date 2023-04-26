package capjjangdol.mallangkongth;

import capjjangdol.mallangkongth.domain.rearing.FoodBowl;
import capjjangdol.mallangkongth.domain.rearing.WaterBowl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.*;
import javax.transaction.Transactional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@SpringBootTest
class MallangKongthApplicationTests {
//	EntityManagerFactory emf = Persistence.createEntityManagerFactory("entityTest");

	@PersistenceContext
	@Autowired
	EntityManager em;

	EntityTransaction ts;


	@Test
	void contextLoads() {
	}

	@Test
	@Transactional
	void RearingEntityTest(){

		FoodBowl foodBowl1 = new FoodBowl();

		foodBowl1.setSettingAmount(500L);
		foodBowl1.setRemaining(200L);
		foodBowl1.eatingAmount();
		em.persist(foodBowl1);


		WaterBowl waterBowl1 = new WaterBowl();
		waterBowl1.setSettingAmount(500L);
		waterBowl1.setRemaining(200L);
		waterBowl1.eatingAmount();
		em.persist(waterBowl1);

	}
	@Test
//	@Transactional
	void RearingEntityfindTest(){
		FoodBowl findFoodBowl = em.find(FoodBowl.class,id);
		System.out.println(findFoodBowl.getSettingAmount()+","+findFoodBowl.getRemaining()+","+findFoodBowl.eatingAmount());

		WaterBowl findWaterBowl = em.find(WaterBowl.class, id);
		System.out.println(findWaterBowl.getSettingAmount()+","+findWaterBowl.getRemaining()+","+findWaterBowl.eatingAmount());
	}
}
