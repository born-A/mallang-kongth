package capjjangdol.mallangkongth.Controller;

import capjjangdol.mallangkongth.domain.mypage.ChangePwReqDto;
import capjjangdol.mallangkongth.domain.mypage.Member;
import capjjangdol.mallangkongth.domain.mypage.MemberReqDto;
import capjjangdol.mallangkongth.domain.mypage.MemberResDto;
import capjjangdol.mallangkongth.service.AuthService;
import capjjangdol.mallangkongth.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/me")
    public String getMyMemberInfo(Model model) {
        Member myInfoBySecurity = memberService.getMyInfoBySecurity();
        System.out.println(myInfoBySecurity.getName());
        model.addAttribute(myInfoBySecurity);
        // return ResponseEntity.ok(memberService.getMyInfoBySecurity());
    }

    @PostMapping("/name")
    public String getMemberName(Model model) {
        Member member =memberService.changeMembername(member.getEmail(), member.getName());
        return"/";
    }

    @PostMapping("/pw")
    public String setMemberPw(ChangePwReqDto request) {
        memberService.changeMemberPw(request.getExPw(), request.getNewPw());
        return "/login/me";
    }

}
