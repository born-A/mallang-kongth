package capjjangdol.mallangkongth.repository;

import capjjangdol.mallangkongth.domain.community.board.PageResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardRepositoryCustom {
    Page<PageResponseDto> searchAll (Pageable pageable);
}
