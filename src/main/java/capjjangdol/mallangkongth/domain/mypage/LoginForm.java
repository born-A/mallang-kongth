//package capjjangdol.mallangkongth.domain.mypage;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Pattern;
//@Getter@Setter
//public class LoginForm {
//
//    @NotBlank(message = "입력해주세요.")
//    @Pattern(regexp = "^[a-z0-9]{4,20}$", message = "???? ?? ???? ??? ???? 4~20???? ???.")
//    private String email;
//
//    @NotBlank(message = "입력해주세요.")
//    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,16}$", message = "????? 8~16????? ???. ?? ????, ??, ????? 1? ?? ???? ???.")
//    private String pw;
//
//
//
//    public void encryptPassword(String BCryptpassword) {
//        this.pw = BCryptpassword;
//    }
//
//    public Member toEntity() {
//        Member member = Member.builder()
//                .email(email)
//                .pw(pw)
//                .build();
//        return member;
//    }
//}
