package capjjangdol.mallangkongth.domain.community.board;

import capjjangdol.mallangkongth.domain.community.Category;
import capjjangdol.mallangkongth.domain.mypage.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@DiscriminatorValue("Q")
public class Question extends Board {

}
