package capjjangdol.mallangkongth.Controller;

import capjjangdol.mallangkongth.repository.domain.mypage.Address;
import capjjangdol.mallangkongth.repository.domain.mypage.LoginForm;
import capjjangdol.mallangkongth.repository.domain.mypage.Member;
import capjjangdol.mallangkongth.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class MemberController {

    private MemberService memberService;
//    @PostMapping("/login")
//    public Long login(@RequestBody MemberLoginRequestDto memberLoginRequestDto) {
//        String email = memberLoginRequestDto.getEmail();
//        String pw = memberLoginRequestDto.getPw();
////        TokenDto tokendto = memberService.login(email, pw);
//        return "/login";
//    }
    @GetMapping("/login/new")
    public String createLoginForm(Model model){
    List<Member> members = memberService.findMembers();
            model.addAttribute("members", members);
            model.addAttribute("form",new LoginForm());
            return "redirect:/login";
    }
    @GetMapping("/auth/signUp")
    public String signUp(){
        return "/auth/signUp";
    }
    @PostMapping("/auth/signUpProcess")
    public String joinProcess(Address.SignUpForm requestDto, BindingResult bindingResult, Model model){
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
//
//        memberService.signUp(requestDto);
        log.info("signUp success");
        return "redirect:/guest";
    }
    @GetMapping("/signUpProcess/{email}/exists")
    public ResponseEntity<Boolean> checkEmailDuplicate(@PathVariable String email){
        return ResponseEntity.ok(memberService.checkEmailDuplication(email));
    }
}
