package capjjangdol.mallangkongth.repository;

import capjjangdol.mallangkongth.domain.mypage.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}