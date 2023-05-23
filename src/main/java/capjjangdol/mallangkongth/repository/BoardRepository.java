package capjjangdol.mallangkongth.repository;

import capjjangdol.mallangkongth.domain.community.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long>,BoardRepositoryCustom {

}
