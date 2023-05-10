package capjjangdol.mallangkongth.repository.domain.community.board;

import capjjangdol.mallangkongth.repository.domain.community.Sex;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@DiscriminatorValue("M")
public class Missing extends Board{
    private String breed;
    private String area;
    private Enum<Sex> sex;
    private LocalDateTime rescueDate;

}
