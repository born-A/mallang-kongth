package capjjangdol.mallangkongth.repository.domain.community.comment;

import capjjangdol.mallangkongth.repository.domain.community.board.Board;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@DiscriminatorValue("IC")
public class InformationComment extends Board {

}
