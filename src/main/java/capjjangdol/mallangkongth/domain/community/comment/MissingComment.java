package capjjangdol.mallangkongth.domain.community.comment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@DiscriminatorValue("MC")
public class MissingComment extends Comment{

}
