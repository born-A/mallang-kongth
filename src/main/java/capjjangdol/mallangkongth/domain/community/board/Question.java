package capjjangdol.mallangkongth.domain.community.board;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@DiscriminatorValue("Q")
public class Question extends Board {

}
