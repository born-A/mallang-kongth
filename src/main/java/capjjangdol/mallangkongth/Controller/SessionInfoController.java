package capjjangdol.mallangkongth.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Slf4j
@Controller
public class SessionInfoController {
@GetMapping("/session-info")
    public String sessionInfo(HttpServletRequest request){
        HttpSession httpSession = request.getSession(false);
        if(httpSession == null){
            return "session is empty";
        }
       Map<String, String[]> paramMap = request.getParameterMap();
       paramMap.forEach((key, value)->log.info("session name={}","value={}",key,request.getParameter(key)));
        log.info("sessionId={}", request.getSession().getId());
        log.info("maxInactiveInterval={}", request.getSession().getMaxInactiveInterval());
        log.info("createionTime={}",new Date(request.getSession().getCreationTime()));
        log.info("lastAccessTime={}", new Date(request.getSession().getLastAccessedTime()));
        log.info("isNew={}", httpSession.isNew());
        return "print session";
    }

}
