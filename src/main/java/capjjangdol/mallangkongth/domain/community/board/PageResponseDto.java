package capjjangdol.mallangkongth.domain.community.board;

import lombok.Builder;
import lombok.Getter;

import java.time.format.DateTimeFormatter;

@Getter
@Builder
//@NoArgsConstructor
public class PageResponseDto {
    // 게시판 목록 :게시판 id, 게시판 제목, 작성자 이름, 작성일
    private Long boardId;
    private String boardTitle;
    private String memberName;
    private String createdAt;


    public static PageResponseDto of(Board board) {
        return PageResponseDto.builder()
                .boardId(board.getId())
                .boardTitle(board.getTitle())
                .memberName(board.getMember().getName())
                .createdAt(board.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .build();
    }

}