package capjjangdol.mallangkongth.Controller;

import Validator.CheckEmailValidator;
import capjjangdol.mallangkongth.domain.mypage.JoinForm;
import capjjangdol.mallangkongth.domain.mypage.LoginForm;
import capjjangdol.mallangkongth.domain.mypage.Member;
import capjjangdol.mallangkongth.repository.MemberRepository;
import capjjangdol.mallangkongth.service.MemberService;
import jnr.a64asm.Mem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@Controller
public class MemberController {
    private CheckEmailValidator checkUser_idValidator;
    private MemberService memberService;
    @Autowired
    private MemberRepository memberRepository;
    @GetMapping("/join/new")
    public String createJoinForm(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        model.addAttribute("form", new JoinForm());
        return "/join/joinForm";
    }
    @PostMapping("/join/new")
    public String createMember(JoinForm joinForm){
        memberService.join(joinForm);
        return "redirect:/join";
    }
    @PostMapping("/join/joinProcess")
    public String joinProcess(JoinForm joinForm, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()) {
            model.addAttribute("joinForm", joinForm);

            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error : bindingResult.getFieldErrors()) {
                errorMap.put("valid_"+error.getField(), error.getDefaultMessage());
                log.info("join failed! error message : "+error.getDefaultMessage());
            }


            for(String key : errorMap.keySet()) {
                model.addAttribute(key, errorMap.get(key));
            }

            return "/join";
            //확인해볼것
        }


        memberService.join(joinForm);
        log.info("join success");
        return "redirect:/join";
    }
    @GetMapping("/join/joinProcess/{email}/exists")
    public ResponseEntity<Boolean> checkEmailDuplicate(@PathVariable String email){
        return ResponseEntity.ok(memberService.checkEmailDuplication(email));
    }
}
