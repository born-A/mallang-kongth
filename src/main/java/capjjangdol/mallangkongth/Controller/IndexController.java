package capjjangdol.mallangkongth.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Log
@RequiredArgsConstructor
@RestController
public class IndexController {

    @GetMapping("/")
    public String main(){
        log.info("main");
        return "main";
    }

    @RequestMapping("/user")
    public void forUser(){
        log.info("user");
    }

    @RequestMapping("/manager")
    public void forManager(){
        log.info("manager");
    }
    @RequestMapping("/admin")
    public void forAdmin(){
        log.info("admin");
    }


}
