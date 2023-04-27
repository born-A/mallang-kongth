package capjjangdol.mallangkongth.domain.community.comment;

import capjjangdol.mallangkongth.domain.community.board.Board;
import capjjangdol.mallangkongth.domain.community.board.Information;
import capjjangdol.mallangkongth.domain.mypage.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@DiscriminatorValue("IC")
public class InformationComment extends Board {

}
