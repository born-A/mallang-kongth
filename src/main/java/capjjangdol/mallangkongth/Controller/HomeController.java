package capjjangdol.mallangkongth.Controller;

import capjjangdol.mallangkongth.config.SessionManager;
import capjjangdol.mallangkongth.domain.mypage.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class HomeController {
    private SessionManager sessionManager;
    @RequestMapping("/")
    public String home(HttpServletRequest httpServletRequest, Model model){
        log.info("home controller");
        Member member = (Member) sessionManager.getSession(httpServletRequest);
        if (member == null){
            return "home";
        }
    model.addAttribute("member",member);
        return "loginhome";
    }
//        @RequestMapping("/")
//    public String home(){
//        log.info("home controller");
//        return "index";
//    }
}
