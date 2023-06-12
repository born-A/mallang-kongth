//package capjjangdol.mallangkongth.RepositoryTest;
//
//import capjjangdol.mallangkongth.domain.community.Category;
//import capjjangdol.mallangkongth.domain.community.board.Board;
//import capjjangdol.mallangkongth.domain.mypage.Address;
//import capjjangdol.mallangkongth.domain.mypage.Member;
//import capjjangdol.mallangkongth.dto.BoardDto;
//import capjjangdol.mallangkongth.repository.BoardRepository;
//import capjjangdol.mallangkongth.repository.MemberRepository;
//import jnr.a64asm.Mem;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.stream.IntStream;
//
//import static org.junit.Assert.*;
//
//public class BoardRepositoryTest {
//    @Autowired
//    BoardRepository boardRepository;
//    @Autowired
//    MemberRepository memberRepository;
//    @Test
//    public void saveTest() {
//     Member member = memberRepository.save(Member.createMember("sujin@naverr.com","12345test","sujin", Address.createAddress("dd","ddsd","dddddd")));
//     boardRepository.save(Board.builder()
//             .title("titletest")
//             .content("contenttest")
//             .category(Category.INFORMATION)
//             .writer("sujinKim")
//             .member(member)
//             .build());
//
//    }
//
//    @Test
//    public void findByMember() {
//        String email = "sujin@naverr.com";
//        Member member = memberRepository.findByEmail(email).get();
//        Board board = boardRepository.findByMember(member);
//        assertEquals(member,board);
//    }
//}