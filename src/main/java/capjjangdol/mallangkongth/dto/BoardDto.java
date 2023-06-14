package capjjangdol.mallangkongth.dto;

import capjjangdol.mallangkongth.domain.community.Category;
import capjjangdol.mallangkongth.domain.community.board.Board;
import capjjangdol.mallangkongth.domain.mypage.Member;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
    private Long id;
    private String writer;
    private String title;
    private String content;


    private Category category;
    private LocalDateTime createdDate;
    private LocalDateTime modifitedDate;

    private Member member;


    public Board toEntity(){
        Board board = Board.builder()
                .id(id)
                .title(title)
                .content(content)
                .writer(writer)
                .category(category)
                .build();
        return board;
    }

    @Builder
    public BoardDto(Long id, String title, String content, String writer, LocalDateTime createdDate, LocalDateTime modifitedDate , Category category, Member member){
        this.id = id;
        this.writer =writer;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.modifitedDate = modifitedDate;
        this.category = category;
//        this.member = member;
    }
//    public void setMember(Member member){
//        this.member = member;
//    }

}
