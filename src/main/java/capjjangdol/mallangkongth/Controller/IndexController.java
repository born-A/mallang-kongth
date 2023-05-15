package capjjangdol.mallangkongth.Controller;

import capjjangdol.mallangkongth.dto.MemberSignUpRequestDto;
import capjjangdol.mallangkongth.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping("/pet")
    public String Pet(){
        return "pet";
    }

    @GetMapping("/rearing")
    public String rearing(){
        return "rearing";
    }

}
