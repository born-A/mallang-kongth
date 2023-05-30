package capjjangdol.mallangkongth.domain.community.board;

import lombok.Getter;

@Getter
public class CreateBoardRequestDto {
    //게시물 생성/수정
    private String title;
    private String mainText;
}
