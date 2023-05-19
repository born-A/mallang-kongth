package capjjangdol.mallangkongth.repository;
import capjjangdol.mallangkongth.domain.mypage.Pet;
import capjjangdol.mallangkongth.domain.rearing.Health;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PetRepository {

    private final EntityManager em;

    public void save(Pet pet) {
        em.persist(pet);
    }

    public Pet findOne(Long id) {
        return em.find(Pet.class, id);
    }

    public List<Pet> findAll() {
        return em.createQuery("select p from Pet p", Pet.class).getResultList();
    }

    public List<Pet> findByName(String name) {
        return em.createQuery("select p from Pet p where p.name = :name", Pet.class)
                .setParameter("name", name)
                .getResultList();
    }
    /**
     * 반려동물 삭제
     */
    public List<Pet> deleteById(Long id){
        return em.createQuery("delete from Pet p where p.id =: id", Pet.class).getResultList();
    }
}