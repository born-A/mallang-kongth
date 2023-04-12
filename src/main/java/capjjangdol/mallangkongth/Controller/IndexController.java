package capjjangdol.mallangkongth.Controller;

import org.springframework.web.bind.annotation.GetMapping;

public class IndexController {

    @GetMapping("/")
    public String main(){
        return "main";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/register")
    public String register(){
        return "register";
    }
    @GetMapping("/pet")
    public String Pet(){
        return "pet";
    }
}
