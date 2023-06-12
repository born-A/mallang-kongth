package capjjangdol.mallangkongth.Controller;

import capjjangdol.mallangkongth.config.SessionManager;
import capjjangdol.mallangkongth.domain.file.FileEntity;
import capjjangdol.mallangkongth.domain.mypage.LoginForm;
import capjjangdol.mallangkongth.domain.mypage.Member;
import capjjangdol.mallangkongth.repository.FileRepository;
import capjjangdol.mallangkongth.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
@Slf4j
public class HomeController {


    private SessionManager sessionManager;
    private FileRepository fileRepository;

    /*@GetMapping("/")
    public String home(HttpServletRequest httpServletRequest, Model model){
        log.info("home controller");
        Member member = (Member) sessionManager.getSession(httpServletRequest);
        if(member == null){
        return "home";}
        model.addAttribute("member",member);
        return "loginHome";
    }*/

    @RequestMapping ("/")
    public String homeLogin(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false)Member member, Model model){
        /** 로그인 페이지로 이동 **/
        if(member == null) {
            model.addAttribute("loginForm", new LoginForm());
            return "logins/sign-in";
        }

        /** 메인 페이지로 이동 **/
//        List<FileEntity> files = fileRepository.findAll();
//        model.addAttribute("all",files);
        model.addAttribute("member", member);
        return "index";
    }
//        @RequestMapping("/")
//    public String home(){
//        log.info("home controller");
//        return "bootstrap/about";
//    }
}
