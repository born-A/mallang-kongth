package capjjangdol.mallangkongth.repository;

import capjjangdol.mallangkongth.domain.rearing.Health;
import capjjangdol.mallangkongth.domain.rearing.HospitalNote;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class HospitalRepository {
    private final EntityManager em;
    public void save(HospitalNote hospitalNote) {

        em.persist(hospitalNote);
    }
    public HospitalNote findOne(Long id) {
        return em.find(HospitalNote.class, id);
    }


    public List<HospitalNote> findAll() {
        return em.createQuery("select h from HospitalNote h",HospitalNote.class).getResultList();
    }

    /**
     * 건강기록 삭제
     */
    public List<HospitalNote> deleteById(Long id) {
        return em.createQuery("delete from HospitalNote h where h.id =: id", HospitalNote.class).getResultList();
    }


}

