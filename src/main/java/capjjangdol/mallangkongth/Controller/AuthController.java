package capjjangdol.mallangkongth.Controller;

import capjjangdol.mallangkongth.domain.mypage.MemberReqDto;
import capjjangdol.mallangkongth.domain.mypage.MemberResDto;
import capjjangdol.mallangkongth.jwt.TokenDto;

import capjjangdol.mallangkongth.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/join")
    public ResponseEntity<MemberResDto> join(@RequestBody MemberReqDto reqDto) {

        System.out.println(authService==null);
        return ResponseEntity.ok(authService.join(reqDto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody MemberReqDto reqDto) {
        return ResponseEntity.ok(authService.login(reqDto));
    }

}
