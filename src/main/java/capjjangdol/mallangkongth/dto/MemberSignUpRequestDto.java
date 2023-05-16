package capjjangdol.mallangkongth.dto;

import capjjangdol.mallangkongth.repository.domain.mypage.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Data
@Builder
public class MemberSignUpRequestDto {


        private Long id;

        @NotBlank(message = "???? ?? ??????.")
        @Pattern(regexp = "^[a-z0-9]{4,20}$", message = "???? ?? ???? ??? ???? 4~20???? ???.")
        private String email;

        @NotBlank(message = "??? ?? ??????.")
        @Pattern(regexp = "^[?-?a-zA-Z0-9]{2,10}$" , message = "??? ????? ???? ?? 2~10???? ???.")
        private String name;

        @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,16}$", message = "????? 8~16????? ???. ?? ????, ??, ????? 1? ?? ???? ???.")
        private String pw;
        private Address address;
        private RoleType roleType;
        private List<Orders> ordersList = new ArrayList<>();

        private Pet pet;

        public void encryptPassword(String BCryptpassword) {
            this.pw = BCryptpassword;
        }
        public Member toEntity() {
            Member member = Member.builder()
                    .email(email)
                    .pw(pw)
                    .address(address)
                    .roleType(roleType.USER)
                    .build();
            return member;
        }


}
