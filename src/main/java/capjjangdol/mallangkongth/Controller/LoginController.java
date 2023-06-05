package capjjangdol.mallangkongth.Controller;


import capjjangdol.mallangkongth.domain.mypage.LoginForm;
import capjjangdol.mallangkongth.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public String login(@Valid LoginForm form, BindingResult bindingResult, HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            return "/logins/loginForm";
        }

        Long memberId = loginService.login(form.getEmail(), form.getPassword());

        /**
         * 로그인 성공 처리
         **/

        HttpSession session = request.getSession();


        session.setAttribute(SessionConst.LOGIN_MEMBER, memberId);
        return "redirect:/";
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