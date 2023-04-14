package capjjangdol.mallangkongth.domain.community.comment;

import capjjangdol.mallangkongth.domain.community.board.Question;
import capjjangdol.mallangkongth.domain.mypage.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@DiscriminatorValue("QC")
public class QuestionComment extends Comment{
}
