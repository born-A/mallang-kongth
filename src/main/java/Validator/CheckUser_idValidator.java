package Validator;


import capjjangdol.mallangkongth.repository.MemberRepository;
import capjjangdol.mallangkongth.dto.MemberSignUpRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
@RequiredArgsConstructor
@Component
public class CheckUser_idValidator extends AbstractValidator<MemberSignUpRequestDto> {
    private final MemberRepository memberRepository;

    @Override
    protected void doValidate(MemberSignUpRequestDto requestDto, Errors errors) {
        if (memberRepository.existsByEmail(requestDto.toEntity().getEmail())) {
            /* ??? ?? */
            errors.rejectValue("user_id","??? ?? ??", "?? ?? ?? ??????.");
        }
    }
}