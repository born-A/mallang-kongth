package capjjangdol.mallangkongth.Controller;

import Validator.CheckUser_idValidator;
import capjjangdol.mallangkongth.login.LoginForm;
import capjjangdol.mallangkongth.repository.domain.mypage.Member;
import capjjangdol.mallangkongth.repository.domain.mypage.Pet;
import capjjangdol.mallangkongth.service.MemberService;
import capjjangdol.mallangkongth.dto.MemberSignUpRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
public class MemberController {
    private CheckUser_idValidator checkUser_idValidator;
    private MemberService memberService;
    @PostMapping("/login")
    public String login(@Valid @RequestBody MemberSignUpRequestDto memberSignUpRequestDto){
        return memberService.login(memberSignUpRequestDto);
    }
    @GetMapping("/login/new")
    public String createLoginForm(Model model){
    Optional<Member> members = memberService.findMembers();
            model.addAttribute("members", members);
            model.addAttribute("form",new LoginForm());
            return "login/loginForm";
    }
    @GetMapping("/auth/signUp")
    public String signUp(){
        return "/auth/signUp";
    }
    @PostMapping("/auth/signUpProcess")
    public String joinProcess(MemberSignUpRequestDto requestDto, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()) {
            model.addAttribute("memberDto", requestDto);


            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error : bindingResult.getFieldErrors()) {
                errorMap.put("valid_"+error.getField(), error.getDefaultMessage());
                log.info("signUp failed! error message : "+error.getDefaultMessage());
            }


            for(String key : errorMap.keySet()) {
                model.addAttribute(key, errorMap.get(key));
            }

            return "/auth/signUp";
        }

        memberService.signUp(requestDto);
        log.info("signUp success");
        return "redirect:/auth/signUp";
    }
    @GetMapping("/auth/signUpProcess/{email}/exists")
    public ResponseEntity<Boolean> checkEmailDuplicate(@PathVariable String email){
        return ResponseEntity.ok(memberService.checkEmailDuplication(email));
    }
}
