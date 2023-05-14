package capjjangdol.mallangkongth.repository.domain.mypage;

import lombok.Getter;
import org.hibernate.validator.constraints.Email;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

//로그인한 사용자 정보 참조할때 account 감싸는 adapter
@Getter
public class MemberAdapter extends User {
    public MemberAdapter(Member member){
        super(member.getEmail(), member.getPw(),
                AuthorityUtils.createAuthorityList(member.getRoleType().toString()));
    }
    public String getEmail(){
        return this.getUsername();
    }
}
