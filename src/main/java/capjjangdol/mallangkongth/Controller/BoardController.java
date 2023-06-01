package capjjangdol.mallangkongth.Controller;

import capjjangdol.mallangkongth.domain.community.board.*;
import capjjangdol.mallangkongth.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;
    @GetMapping("/page")
    public ResponseEntity<Page<PageResponseDto>> pageBoard(@RequestParam(name = "page") int page) {
        return ResponseEntity.ok(boardService.pageBoard(page));
    }

    @GetMapping("/one")
    public ResponseEntity<BoardResponseDto> getOneBoard(@RequestParam(name = "id") Long id) {
        return ResponseEntity.ok(boardService.oneboard(id));
    }

    @PostMapping("/")
    public ResponseEntity<BoardResponseDto> createBoard(@RequestBody CreateBoardRequestDto request) {
        return ResponseEntity.ok(boardService.postBoard(request.getTitle(), request.getMainText()));
    }

    @GetMapping("/change")
    public ResponseEntity<BoardResponseDto> getChangeBoard(@RequestParam(name = "id") Long id) {
        return ResponseEntity.ok(boardService.oneboard((id)));
    }

    @PutMapping("/")
    public ResponseEntity<BoardResponseDto> putChangeBoard(@RequestBody ChangeBoardRequestDto request) {
        return ResponseEntity.ok(boardService.changeBoard(
                request.getId(), request.getTitle(), request.getMainText()
        ));
    }

    @DeleteMapping("/one")
    public ResponseEntity<MessageDto> deleteArticle(@RequestParam(name = "id") Long id) {
        boardService.deleteBoard(id);
        return ResponseEntity.ok(new MessageDto("Success"));
    }


}
