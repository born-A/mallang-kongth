package capjjangdol.mallangkongth.domain.rearing;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ingredient {

    @Id @GeneratedValue
    private Long id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
