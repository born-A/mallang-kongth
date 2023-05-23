package capjjangdol.mallangkongth.Controller;

import capjjangdol.mallangkongth.domain.mypage.ChangePwReqDto;
import capjjangdol.mallangkongth.domain.mypage.MemberReqDto;
import capjjangdol.mallangkongth.domain.mypage.MemberResDto;
import capjjangdol.mallangkongth.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/me")
    public ResponseEntity<MemberResDto> getMyMemberInfo() {
        MemberResDto myInfoBySecurity = memberService.getMyInfoBySecurity();
        System.out.println(myInfoBySecurity.getName());
        return ResponseEntity.ok((myInfoBySecurity));
        // return ResponseEntity.ok(memberService.getMyInfoBySecurity());
    }

    @PostMapping("/name")
    public ResponseEntity<MemberResDto> setMemberName(@RequestBody MemberReqDto req) {
        return ResponseEntity.ok(memberService.changeMembername(req.getEmail(), req.getName()));
    }

    @PostMapping("/pw")
    public ResponseEntity<MemberResDto> setMemberPw(@RequestBody ChangePwReqDto request) {
        return ResponseEntity.ok(memberService.changeMemberPw(request.getExPw(), request.getNewPw()));
    }

}
