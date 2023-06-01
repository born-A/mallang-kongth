package capjjangdol.mallangkongth.config;

import capjjangdol.mallangkongth.domain.mypage.Member;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.junit.Assert.*;

public class SessionManagerTest {
    SessionManager sessionManager = new SessionManager();
    @Test
    public void sessionTest(){
        MockHttpServletResponse response = new MockHttpServletResponse();
        Member member = new Member();
        sessionManager.createSession(member,response);

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setCookies(response.getCookies());

        Object result = sessionManager.getSession(request);
        assertEquals(result,member);
        System.out.println(result);

        sessionManager.expire(request);
        Object expired = sessionManager.getSession(request);
        assertEquals(expired, null);

    }

}