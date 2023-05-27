package capjjangdol.mallangkongth.Controller;

import capjjangdol.mallangkongth.domain.mypage.*;
//import capjjangdol.mallangkongth.jwt.TokenDto;

import capjjangdol.mallangkongth.service.AuthService;
import jnr.a64asm.Mem;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.mapping.Join;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private  PasswordEncoder passwordEncoder;
    @GetMapping("/join")
    public String CreateJoinForm(Model model){
        model.addAttribute("joinForm", new JoinForm());
        return "auth/createJoinForm";
    }
    @PostMapping("/join")
    public String join(Model model,JoinForm joinForm) {
        Member member = Member.createMember(joinForm, passwordEncoder);
        member.setEmail(joinForm.getEmail());
        member.setName(joinForm.getName());
        member.setPw(joinForm.getPw());
        member.setAddress(joinForm.getAddress());

        authService.join(member);
        return "redirect:/";
    }
    @PostMapping("/joinProc")
    public String newMember(@Valid JoinForm joinForm, BindingResult bindingResult,Model model) {
        if (bindingResult.hasErrors()) {
            return "auth/createJoinForm";
        }

        try {
            Member member = Member.createMember(joinForm, passwordEncoder);
        } catch (IllegalStateException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "auth/createJoinForm";
        }

        return "redirect:/";
    }
    @GetMapping("/login")
    public String CreateLoginForm(){
        return "auth/createLoginForm";
    }

    @GetMapping("/login/error")
    public String loginError(Model model) {
        model.addAttribute("loginErrorMsg","아이디 또는 패스워드를 확인해주세요");
        return "auth/createLoginForm";
    }

}
