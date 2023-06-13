package capjjangdol.mallangkongth.RepositoryTest;

import capjjangdol.mallangkongth.domain.community.BoardCategory;
import capjjangdol.mallangkongth.domain.community.Category;
import capjjangdol.mallangkongth.domain.community.board.Board;
import capjjangdol.mallangkongth.domain.mypage.Address;
import capjjangdol.mallangkongth.domain.mypage.Member;
import capjjangdol.mallangkongth.dto.BoardDto;
import capjjangdol.mallangkongth.repository.BoardRepository;
import capjjangdol.mallangkongth.repository.MemberRepository;
import jnr.a64asm.Mem;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class BoardRepositoryTest {
    @Autowired
    BoardRepository boardRepository;
    @Test
    public void saveTest() {
     boardRepository.save(Board.builder()
             .title("titletest")
             .content("contenttest")
             .category(BoardCategory.INFORMATION)
             .writer("sujinKim")
             .build());

    }

    @Test
    public void findByTitle() {
    }
}