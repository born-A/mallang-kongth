package capjjangdol.mallangkongth.repository;

import capjjangdol.mallangkongth.domain.rearing.FoodBowl;
import capjjangdol.mallangkongth.domain.rearing.FoodNote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodNoteRepository extends JpaRepository<FoodNote, Long> {
}
