package capjjangdol.mallangkongth.repository.domain.mypage;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RoleType {
    GUEST("ROLE_GUEST", "게스트"),
    USER("ROLE_USER", "회원"),
    ADMIN("ROLE_ADMIN", "관리자");
    private final String key;
    private final String title;
}
