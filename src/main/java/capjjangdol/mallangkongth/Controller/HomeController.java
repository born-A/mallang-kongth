package capjjangdol.mallangkongth.Controller;

import capjjangdol.mallangkongth.config.SessionManager;
import capjjangdol.mallangkongth.domain.mypage.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class HomeController {
@Autowired
    private SessionManager sessionManager;
    @GetMapping("/")
    public String home(HttpServletRequest httpServletRequest, Model model){
        ModelAndView modelAndView = new ModelAndView();

//        Member member = (Member) sessionManager.getSession(httpServletRequest);
//        if(member == null){
//            return "about";
//        }
//        log.info(member.toString());
//        model.addAttribute("member",member);
        log.info("not null");
        return "index";
    }

//        @RequestMapping("/")
//    public String home(){
//        log.info("home controller");
//        return "index";
//    }
}
