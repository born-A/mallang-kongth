package capjjangdol.mallangkongth.Controller;


import capjjangdol.mallangkongth.domain.mypage.LoginForm;
import capjjangdol.mallangkongth.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@Slf4j
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/api/login")
    public ResponseEntity<String> login(@RequestBody LoginForm form, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Validation failed"); // 유효성 검사 실패 시 에러 응답
        }

        Long memberId = loginService.login(form.getEmail(), form.getPassword());

        if (memberId != null) {
            // 로그인 성공 시 세션에 사용자 정보를 저장하고 성공 응답을 반환
            HttpSession session = request.getSession();
            session.setAttribute(SessionConst.LOGIN_MEMBER, memberId);
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed"); // 로그인 실패 시 에러 응답
        }
    }

    @PostMapping(value = "logout.do")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }

}