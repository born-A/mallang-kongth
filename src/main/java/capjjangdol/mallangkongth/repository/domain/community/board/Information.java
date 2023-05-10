package capjjangdol.mallangkongth.repository.domain.community.board;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@DiscriminatorValue("I")
public class Information extends Board{

}
