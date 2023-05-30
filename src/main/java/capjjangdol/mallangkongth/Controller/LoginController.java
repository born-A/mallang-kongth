//package capjjangdol.mallangkongth.Controller;
//
//import capjjangdol.mallangkongth.domain.mypage.ChangePwReqDto;
//import capjjangdol.mallangkongth.domain.mypage.MemberReqDto;
//import capjjangdol.mallangkongth.domain.mypage.MemberResDto;
//import capjjangdol.mallangkongth.service.AuthService;
//import capjjangdol.mallangkongth.service.MemberService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//@RequiredArgsConstructor
//@Slf4j
//@RequestMapping("/login")
//public class LoginController {
//    private final AuthService authService;
//
////    @GetMapping("/me")
////    public ResponseEntity<MemberResDto> getMyMemberInfo() {
////        MemberResDto myInfoBySecurity = memberService.getMyInfoBySecurity();
////        System.out.println(myInfoBySecurity.getName());
////        return ResponseEntity.ok((myInfoBySecurity));
////        // return ResponseEntity.ok(memberService.getMyInfoBySecurity());
////    }
////
////    @PostMapping("/name")
////    public ResponseEntity<MemberResDto> setMemberName(@RequestBody MemberReqDto req) {
////        return ResponseEntity.ok(memberService.changeMembername(req.getEmail(), req.getName()));
////    }
////
////    @PostMapping("/pw")
////    public ResponseEntity<MemberResDto> setMemberPw(@RequestBody ChangePwReqDto request) {
////        return ResponseEntity.ok(memberService.changeMemberPw(request.getExPw(), request.getNewPw()));
////    }
//
//}
