package capjjangdol.mallangkongth.service;

import capjjangdol.mallangkongth.dto.BoardDto;
import capjjangdol.mallangkongth.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private BoardRepository boardRepository;
    public List<BoardDto> getBoardlist(Integer pageNum) {
        return boardRepository.findAll(getBoardlist());
    }
}
