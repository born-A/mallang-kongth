package capjjangdol.mallangkongth.repository;

import capjjangdol.mallangkongth.domain.community.board.Board;
import capjjangdol.mallangkongth.domain.mypage.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByTitle(String keyword);
//    Board findByMember (Member member);
}
