package capjjangdol.mallangkongth.Controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log
public class IndexController {

    @GetMapping("/")
    public String main(){
        log.info("main");
        return "main";
    }
    @GetMapping("/login")
    public String login(){
        log.info("login");
        return "login";
    }
    @RequestMapping("/guest")
    public void forGuest(){
        log.info("guest");
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
