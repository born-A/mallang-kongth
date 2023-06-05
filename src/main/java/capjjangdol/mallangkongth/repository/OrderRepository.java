package capjjangdol.mallangkongth.repository;

import capjjangdol.mallangkongth.domain.mypage.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long>{

}