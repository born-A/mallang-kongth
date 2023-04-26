package capjjangdol.mallangkongth.domain.community.board;

import capjjangdol.mallangkongth.domain.community.Category;
import capjjangdol.mallangkongth.domain.mypage.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@DiscriminatorValue("I")
public class Information extends Board{

}
