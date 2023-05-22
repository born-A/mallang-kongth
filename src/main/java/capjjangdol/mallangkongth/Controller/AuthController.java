package capjjangdol.mallangkongth.Controller;

//import Validator.CheckEmailValidator;
import capjjangdol.mallangkongth.domain.mypage.Member;
import capjjangdol.mallangkongth.domain.mypage.MemberReqDto;
import capjjangdol.mallangkongth.domain.mypage.MemberResDto;
import capjjangdol.mallangkongth.jwt.TokenDto;
import capjjangdol.mallangkongth.repository.MemberRepository;
import capjjangdol.mallangkongth.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

//    @GetMapping("/join")
//    public String createJoinForm(Model model){
//        List<Member> members = authService.findMembers();
//        model.addAttribute("members", members);
//        model.addAttribute("form", new JoinForm());
//        return "/join/joinForm";
//    }
    @PostMapping("/join")
    public ResponseEntity<MemberResDto> join(@RequestBody MemberReqDto reqDto) {

        System.out.println(authService==null);
        return ResponseEntity.ok(authService.join(reqDto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody MemberReqDto reqDto) {
        return ResponseEntity.ok(authService.login(reqDto));
    }


//    @PostMapping("/join/joinProcess")
//    public String joinProcess(JoinForm joinForm, BindingResult bindingResult, Model model){
//        if(bindingResult.hasErrors()) {
//            model.addAttribute("joinForm", joinForm);
//
//            Map<String, String> errorMap = new HashMap<>();
//
//            for(FieldError error : bindingResult.getFieldErrors()) {
//                errorMap.put("valid_"+error.getField(), error.getDefaultMessage());
//                log.info("join failed! error message : "+error.getDefaultMessage());
//            }
//
//
//            for(String key : errorMap.keySet()) {
//                model.addAttribute(key, errorMap.get(key));
//            }
//
//            return "/join";
//            //확인해볼것
//        }
//
//
//        authService.join(joinForm);
//        log.info("join success");
//        return "redirect:/join";
//    }
//    @GetMapping("/join/joinProcess/{email}/exists")
//    public ResponseEntity<Boolean> checkEmailDuplicate(@PathVariable String email){
//        return ResponseEntity.ok(authService.checkEmailDuplication(email));
//    }
}
