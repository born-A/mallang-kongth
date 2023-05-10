package Validator;


import repository.MemberRepository;
import dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
@RequiredArgsConstructor
@Component
public class CheckUser_idValidator extends AbstractValidator<MemberDto.RequestMemberDto> {
    private final MemberRepository memberRepository;

    @Override
    protected void doValidate(MemberDto.RequestMemberDto dto, Errors errors) {
        if (memberRepository.existsByUser_id(dto.toEntity().getUser_id())) {
            /* ??? ?? */
            errors.rejectValue("user_id","??? ?? ??", "?? ?? ?? ??????.");
        }
    }
}