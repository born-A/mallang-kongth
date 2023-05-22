//package capjjangdol.mallangkongth.Controller;
//
//import Validator.CheckUser_idValidator;
//import capjjangdol.mallangkongth.service.MemberService;
//import capjjangdol.mallangkongth.dto.MemberDto;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.ResponseEntity;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import java.util.HashMap;
//import java.util.Map;
//@Slf4j
//public class MemberController {
//    private CheckUser_idValidator checkUser_idValidator;
//    private MemberService memberService;
//
//    @GetMapping("/auth/join")
//    public String join(){
//        return "join";
//    }
//    @PostMapping("/auth/joinProcess")
//    public String joinProcess(MemberDto.RequestMemberDto memberDto, BindingResult bindingResult, Model model){
//        if(bindingResult.hasErrors()) {
//            model.addAttribute("memberDto", memberDto);
//
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
//            return "join";
//        }
//
//
//        memberService.join(memberDto);
//        log.info("join success");
//        return "redirect:/auth/join";
//    }
//    @GetMapping("/auth/joinProcess/{user_id}/exists")
//    public ResponseEntity<Boolean> checkUser_idDuplicate(@PathVariable String user_id){
//        return ResponseEntity.ok(memberService.checkUser_idDuplication(user_id));
//    }
//}
