package capjjangdol.mallangkongth.dto;

import capjjangdol.mallangkongth.domain.mypage.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

public class MemberDto {
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter @Setter
    @Builder
    public static class RequestMemberDto{
        private Long id;

        @NotBlank(message = "???? ?? ??????.")
        @Pattern(regexp = "^[a-z0-9]{4,20}$", message = "???? ?? ???? ??? ???? 4~20???? ???.")
        private String user_id;

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
            Member memeber = Member.builder()
                    .id(id)
                    .user_id(user_id)
                    .pw(pw)
                    .address(address)
                    .roleType(roleType.USER)
                    .build();
            return memeber;
        }

    }
}
