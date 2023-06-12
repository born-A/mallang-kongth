package capjjangdol.mallangkongth.RepositoryTest;

import capjjangdol.mallangkongth.domain.community.Category;
import capjjangdol.mallangkongth.domain.community.board.Board;
import capjjangdol.mallangkongth.repository.BoardRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import static org.junit.Assert.*;
@SpringBootTest
public class BoardRepositoryTest {
    @Autowired
    BoardRepository boardRepository;
    @Test
    public void saveDummyTest() {
        IntStream.rangeClosed(1,140).forEach(i -> {
            Board board = Board.builder()
                    .title("board_title" + i)
                    .content("board_content"+ i)
                    .writer("board_writer"+i)
                    .category(Category.INFORMATION)
                    .build();
            boardRepository.save(board);
        });
    }

    @Test
    public void findByMember() {
    }
}