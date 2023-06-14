package capjjangdol.mallangkongth.Controller;

import capjjangdol.mallangkongth.dto.BoardDto;
import capjjangdol.mallangkongth.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping({"","/list"})
    public String List(Model model, @RequestParam(value = "page", defaultValue = "1")Integer pageNum){
        List<BoardDto> boardList = boardService.getBoardList(pageNum);
        Integer[] pageList = boardService.getPageList(pageNum);
        model.addAttribute("boardList", boardList);
        model.addAttribute("pageList",pageList);

        return "board/list";
    }
    /**
     글 게시 페이지, 글 게시
     **/
    @GetMapping("/post")
    public String write(){
        return "board/write";
    }

    @PostMapping("/post")
    public String write(BoardDto boardDto){
        boardService.save(boardDto);
        return "redirect:/board/list";
    }
    /**
     글 상세보기
     **/
    @GetMapping("/post/{no}")
    public String detail(@PathVariable("no")Long no, Model model){
        BoardDto boardDto = boardService.getPost(no);
        model.addAttribute("boardDto", boardDto);
        return "board/detail";
    }

    /**
     글 수정
     **/
    @GetMapping("/post/edit/{no}")
    public String edit(@PathVariable("no") Long no, Model model){
        BoardDto boardDto = boardService.getPost(no);
        model.addAttribute("boardDto", boardDto);
        return "board/update";
    }
    @PutMapping("/post/edit/{no}")
    public String update(BoardDto boardDto){
        boardService.save(boardDto);
        return "redirect:/board/list";
    }
    /**
     글 삭제
     **/
    @DeleteMapping("/post/{no}")
    public String delete(@PathVariable("no") Long no){
        boardService.delete(no);
        return "redirect:/board/list";
    }
    /**
     글 검색
     **/
    @GetMapping("/search")
    public String search(@RequestParam(value = "keyword") String keyword,Model model){
        List<BoardDto> boardDtoList = boardService.search(keyword);
        model.addAttribute("boardList", boardDtoList);
        return "board/list";
    }

}
