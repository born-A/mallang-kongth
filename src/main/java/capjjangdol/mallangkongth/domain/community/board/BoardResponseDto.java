package capjjangdol.mallangkongth.domain.community.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardResponseDto {
    //게시판 단독 요소
    private Long boardId;
    private String memberName;
    private String boardTitle;
    private String mainText;
    private String createdAt;
    private String updatedAt;
    private boolean isWritten; //작성여부 -> 작성한 사람만 수정/삭제 가능

    public static BoardResponseDto of(Board board, boolean bool) {
        return BoardResponseDto.builder()
                .boardId(board.getId())
                .memberName(board.getMember().getName())
                .boardTitle(board.getTitle())
                .mainText(board.getMainText())
                .createdAt(board.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .updatedAt(board.getUpdatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .isWritten(bool)
                .build();
    }

}
