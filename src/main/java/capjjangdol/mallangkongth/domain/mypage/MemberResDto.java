package capjjangdol.mallangkongth.domain.mypage;

import capjjangdol.mallangkongth.domain.mypage.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberResDto  {
    private String email;
    private String name;

    public static MemberResDto of(Member member) {
        return MemberResDto.builder()
                .email(member.getEmail())
                .name(member.getName())
                .build();
    }
}
