package capjjangdol.mallangkongth.Controller;

import capjjangdol.mallangkongth.domain.mypage.*;
import capjjangdol.mallangkongth.jwt.TokenDto;

import capjjangdol.mallangkongth.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @GetMapping("/join")
    public String CreateJoinForm(Model model){
        model.addAttribute("joinForm", new JoinForm());
        return "/CreateJoinForm";
    }
    @PostMapping("/join")
    public String join(Model model,MemberReqDto reqDto) {
        MemberResDto join = authService.join(reqDto);
        model.addAttribute("join",join);
        return "redirect:/";
    }
    @GetMapping("/login")
    public String CreateLoginForm(Model model){
        model.addAttribute("loginForm", new LoginForm());
        return "/CreateLoginForm";
    }

    @PostMapping("/login")
    public String login(Model model, MemberReqDto reqDto) {
        TokenDto login = authService.login(reqDto);
        model.addAttribute("login",login);
        return "redirect:/";
    }

}
