package capjjangdol.mallangkongth.repository.domain.rearing;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ingredient {

    @Id @GeneratedValue
    private Long id;

    private String name;

}
