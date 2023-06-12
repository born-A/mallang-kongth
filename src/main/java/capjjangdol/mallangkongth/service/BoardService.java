package capjjangdol.mallangkongth.service;

import capjjangdol.mallangkongth.domain.community.board.Board;
import capjjangdol.mallangkongth.domain.mypage.Member;
import capjjangdol.mallangkongth.dto.BoardDto;
import capjjangdol.mallangkongth.repository.BoardRepository;
import jdk.nashorn.internal.runtime.options.Option;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BoardService {
    private BoardRepository boardRepository;

    private static final int BLOCK_PAGE_NUM_COUNT = 5;
    private static final int PAGE_COUNT = 4;

    private  BoardDto EntityToDto(Board board){
        return BoardDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .createdDate(board.getCreatedDate())
                .modifitedDate(board.getModifiedDate())
                .category(board.getCategory())
                .build();
    }

    @Transactional
    public List<BoardDto> getBoardList(Integer pageNum) {
        Page<Board> page = boardRepository.findAll(PageRequest.of(pageNum -1, PAGE_COUNT, Sort.by(Sort.Direction.ASC, "createdDate")));
    //page, pagesize, page 정렬방식
        List<Board> boardEntities = page.getContent();
        List<BoardDto> boardDtoList  = new ArrayList<>();

        for(Board board: boardEntities){
            boardDtoList.add(this.EntityToDto(board));
        }
        return boardDtoList;
    }

    @Transactional
    public BoardDto getPost(Long id){
        Optional<Board> boardWrapper = boardRepository.findById(id);
        Board board = boardWrapper.get();

        BoardDto boardDto = BoardDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .category(board.getCategory())
                .createdDate(board.getCreatedDate())
                .modifitedDate(board.getModifiedDate())
                .build();
        return boardDto;
    }

    @Transactional
    public Long save(BoardDto boardDto, Member member){
        boardDto.setMember(member);
        return boardRepository.save(boardDto.toEntity()).getId();
    }
    //board.html에는 th:if:${board.member.id== #authentication.principal.id}"로 삭제/수정버튼 글쓴이만 볼수 있도록

    @Transactional
    public void delete(Long id){
        boardRepository.deleteById(id);
    }

    @Transactional
    public List<BoardDto> search(String keyword){
        List<Board> boardEntities = boardRepository.findByTitle(keyword);
        List<BoardDto> boardDtoList = new ArrayList<>();

        if(boardEntities.isEmpty()) return boardDtoList;

        for(Board board : boardEntities){
            boardDtoList.add(this.EntityToDto(board));
        }
        return boardDtoList;
    }
    // 페이징
    @Transactional
    public Long getBoardCount() {
        return boardRepository.count();
    }

    public Integer[] getPageList(Integer curPageNum) {
        Integer[] pageList = new Integer[BLOCK_PAGE_NUM_COUNT];

        // 총 게시글 갯수
        Double postsTotalCount = Double.valueOf(this.getBoardCount());

        // 총 게시글 기준으로 계산한 마지막 페이지 번호 계산 (올림으로 계산)
        Integer totalLastPageNum = (int)(Math.ceil((postsTotalCount/PAGE_COUNT)));

        // 현재 페이지를 기준으로 블럭의 마지막 페이지 번호 계산
        Integer blockLastPageNum = (totalLastPageNum > curPageNum + BLOCK_PAGE_NUM_COUNT)
                ? curPageNum + BLOCK_PAGE_NUM_COUNT
                : totalLastPageNum;

        // 페이지 시작 번호 조정
        curPageNum = (curPageNum <= 3) ? 1 : curPageNum - 2;

        // 페이지 번호 할당
        for (int val = curPageNum, idx = 0; val <= blockLastPageNum; val++, idx++) {
            pageList[idx] = val;
        }

        return pageList;
    }
}
