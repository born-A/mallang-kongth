//package capjjangdol.mallangkongth.service;
//
//import capjjangdol.mallangkongth.config.SecurityUtil;
//import capjjangdol.mallangkongth.domain.community.board.Board;
//import capjjangdol.mallangkongth.domain.community.board.BoardResponseDto;
//import capjjangdol.mallangkongth.domain.community.board.PageResponseDto;
//import capjjangdol.mallangkongth.domain.mypage.Member;
//import capjjangdol.mallangkongth.repository.BoardRepository;
//import capjjangdol.mallangkongth.repository.MemberRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//@Transactional(readOnly = true)
//@RequiredArgsConstructor
//public class BoardService {
//    private final BoardRepository boardRepository;
//    private final MemberRepository memberRepository;
//
//    public List<PageResponseDto> allBoard(){
//        List<Board> boards = boardRepository.findAll();
//        return boards
//                .stream()
//                .map(PageResponseDto ::of)
//                .collect(Collectors.toList());
//
//    }
//
//    /**
//     게시글 조회
//     **/
//    public BoardResponseDto oneboard(Long id) {
//        Board board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("글이 없습니다."));
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication == null || authentication.getPrincipal() == "anonymousUser") {
//            return BoardResponseDto.of(board, false); //작성한 글 없을 때
//        } else {
//            Optional<Member> member = memberRepository.findById(Long.parseLong(authentication.getName())); //member -> optional로 변경
//            boolean result = board.getMember().equals(member);
//            return BoardResponseDto.of(board, result); //작성한 글 있을 때
//        }
//    }
//
//    /**
//     게시글 등록
//     **/
//    @Transactional
//    public BoardResponseDto postBoard(String title, String mainText) {
//        memberRepository.findById(SecurityUtil.getCurrentMemberId())
//                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다"));
//        Board board = Board.createBoard(title, mainText, new Member());
//        return BoardResponseDto.of(boardRepository.save(board), true);
//    }
//
//    /**
//     게시글 수정
//     **/
//    public Member isMemberCurrent() {
//        return memberRepository.findById(SecurityUtil.getCurrentMemberId())
//                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다"));
//    }
//
//
//    @Transactional
//    public BoardResponseDto changeBoard(Long id, String title, String mainText) {
//        Board board = authorizationArticleWriter(id);
//        return BoardResponseDto.of(boardRepository.save(board.changeBoard(board, title, mainText)), true);
//    }
//
//    private Board authorizationArticleWriter(Long id) {
//        Member member = isMemberCurrent();
//        Board board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("글이 없습니다."));
//        if (!board.getMember().equals(member)) {
//            throw new RuntimeException("로그인한 유저와 작성 유저가 같지 않습니다.");
//        }
//        return board;
//    }
//
//    /**
//     삭제
//     **/
//    @Transactional
//    public void deleteBoard(Long id) {
//        Board board = authorizationArticleWriter(id);
//        boardRepository.delete(board);
//    }
//
//    public Page<PageResponseDto> pageBoard(int pageNum){
//        return boardRepository.searchAll(PageRequest.of(pageNum -1,20));
//    }
//}
