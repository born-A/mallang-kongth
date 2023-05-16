package capjjangdol.mallangkongth.service;

import capjjangdol.mallangkongth.repository.MemberRepository;
import capjjangdol.mallangkongth.repository.domain.mypage.Member;
import capjjangdol.mallangkongth.repository.domain.mypage.MemberAdapter;
import capjjangdol.mallangkongth.repository.domain.mypage.RoleType;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
//UserDetailsService : 사용자 이름으로 사용자 검색
@Component("userDetailsService")
@Service
public class CustomerDetailsService implements UserDetailsService{
    private final MemberRepository memberRepository;
    private MemberAdapter memberAdapter;
    private PasswordEncoder passwordEncoder;

    public CustomerDetailsService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("해당 이메일과 일치하는 계정이 없습니다."));

        return new MemberAdapter(member);
    }
    private UserDetails createUserDetails(Member member) {
        return User.builder()
                .username(memberAdapter.getEmail())
                .password(passwordEncoder.encode(member.getPw()))
                .roles(RoleType.USER.getKey())
                .build();
    }

}
