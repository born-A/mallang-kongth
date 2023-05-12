package Validator;


import capjjangdol.mallangkongth.repository.MemberRepository;
import capjjangdol.mallangkongth.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
@RequiredArgsConstructor
@Component
public class CheckUser_idValidator extends AbstractValidator<MemberDto.RequestMemberDto> {
    private final MemberRepository memberRepository;

    @Override
    protected void doValidate(MemberDto.RequestMemberDto dto, Errors errors) {
        if (memberRepository.existsByEmail(dto.toEntity().getEmail())) {
            /* ??? ?? */
            errors.rejectValue("user_id","??? ?? ??", "?? ?? ?? ??????.");
        }
    }
}