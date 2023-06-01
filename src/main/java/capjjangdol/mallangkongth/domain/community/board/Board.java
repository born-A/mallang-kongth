package capjjangdol.mallangkongth.domain.community.board;

import capjjangdol.mallangkongth.domain.community.comment.BoardComment;
import capjjangdol.mallangkongth.domain.community.comment.Comment;
import capjjangdol.mallangkongth.domain.community.comment.Recommend;
import capjjangdol.mallangkongth.domain.mypage.Member;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //한테이블에 다 때려박음
@DiscriminatorColumn(name = "dtype")
public class Board {
    @Id
    @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    @Column(nullable = false)
    private String title; //글 제목

    @Column(nullable = false, columnDefinition = "TEXT")
    private String mainText; //글 내용

    @CreationTimestamp
    @Column
    private LocalDateTime createdAt = LocalDateTime.now(); //작성일자

    @UpdateTimestamp
    @Column
    private LocalDateTime updatedAt = LocalDateTime.now(); //수정일자

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private BoardCategory boardCategory;//게시판 카테고리

    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "board" ,cascade = CascadeType.REMOVE)
    private List<Recommend> recommends = new ArrayList<>();

    public static Board createBoard (String title, String mainText, Member member){
        Board board= new Board();
        board.title = title;
        board.mainText = mainText;
        board.member = member;

        return board;
    }

    public static Board changeBoard (Board board, String title, String mainText){
        board.setTitle(title);
        board.setMainText(mainText);
        return board;
    }



}
