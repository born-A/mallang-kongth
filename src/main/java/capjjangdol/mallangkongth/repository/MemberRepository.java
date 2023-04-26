package capjjangdol.mallangkongth.repository;

import capjjangdol.mallangkongth.domain.mypage.Member;
import org.hibernate.Session;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.core.EntityInformation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

import static javafx.scene.input.KeyCode.T;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{


}
