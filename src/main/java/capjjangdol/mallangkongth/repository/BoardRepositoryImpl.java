//package capjjangdol.mallangkongth.repository;
//
//import capjjangdol.mallangkongth.domain.community.board.Board;
//import capjjangdol.mallangkongth.domain.community.board.PageResponseDto;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.Pageable;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import static capjjangdol.mallangkongth.domain.community.board.QBoard.board;
//
//@RequiredArgsConstructor
//public class BoardRepositoryImpl implements BoardRepositoryCustom{
//    private final JPAQueryFactory queryFactory;
//
//    @Override
//    public Page<PageResponseDto> searchAll(Pageable pageable) {
//        List<Board> content = queryFactory
//                .selectFrom(board)
//                .orderBy(board.id.desc())
//                .offset(pageable.getOffset())
//                .limit(pageable.getPageSize())
//                .fetch();
//        List<PageResponseDto> pages = content
//                .stream()
//                .map(PageResponseDto::of)
//                .collect(Collectors.toList());
//        int totalSize = queryFactory
//                .selectFrom(board)
//                .fetch()
//                .size();
//
//        return new PageImpl<>(pages, pageable, totalSize);
//    }
//}
