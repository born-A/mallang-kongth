package capjjangdol.mallangkongth.service;

import capjjangdol.mallangkongth.domain.mypage.Member;
import capjjangdol.mallangkongth.domain.mypage.Pet;
import capjjangdol.mallangkongth.domain.mypage.RoleType;
import capjjangdol.mallangkongth.repository.PetRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PetServiceTest {
    @Autowired
    PetService petService;
    @Autowired
    PetRepository petRepository;
    @Autowired
    EntityManager em;

    @Test
//    @Rollback(value = false)
    public void petSaveTest() throws Exception{
        //given
        Member member = new Member();
//        member.setName("신예진");
//        member.setRoleType(RoleType.GUEST);
        member.setPw("1111");
//        member.setAddress("aaa bbb1111");
        em.persist(member);

        Pet pet = new Pet();
        pet.setName("moncherr");
        pet.setMember(member);

        //when
        Long saveId = petService.create(pet);
        //then
        em.flush();
        Assert.assertEquals(pet, petRepository.findOne(saveId));
    }



}