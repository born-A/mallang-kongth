//package capjjangdol.mallangkongth.domain.mypage;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import org.springframework.lang.Nullable;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import javax.persistence.Embedded;
//import javax.persistence.Enumerated;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Pattern;
//
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//public class MemberReqDto {
//    private Long id;
//
//    @NotBlank(message = "???? ?? ??????.")
//    @Pattern(regexp = "^[a-z0-9]{4,20}$", message = "???? ?? ???? ??? ???? 4~20???? ???.")
//    private String email;
//
//    @NotBlank(message = "??? ?? ??????.")
//    @Pattern(regexp = "^[?-?a-zA-Z0-9]{2,10}$" , message = "??? ????? ???? ?? 2~10???? ???.")
//    private String name;
//
//    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,16}$", message = "????? 8~16????? ???. ?? ????, ??, ????? 1? ?? ???? ???.")
//    private String pw;
//    @Embedded
//    private Address address;
//
//    private RoleType roleType;
//
////    public Member toMember(PasswordEncoder passwordEncoder) {
////        return Member.builder()
////                .email(email)
////                .pw(passwordEncoder.encode(pw))
////                .name(name)
////                .address(new Address())
////                .roleType(roleType.USER)
////                .build();
////    }
//
////    public UsernamePasswordAuthenticationToken toAuthentication() {
////        return new UsernamePasswordAuthenticationToken(email, pw);
////    }
//}