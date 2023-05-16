package capjjangdol.mallangkongth.dto;

import lombok.*;


@Builder
@AllArgsConstructor
@Data
public class TokenDto {

    private String grantType;
    private String accessToken;
    private String refreshToken;
}
