package capjjangdol.mallangkongth.domain.community.comment;

import capjjangdol.mallangkongth.domain.community.board.Board;
import capjjangdol.mallangkongth.domain.community.board.Missing;
import capjjangdol.mallangkongth.domain.mypage.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@DiscriminatorValue("MC")
public class MissingComment extends Comment{

}
