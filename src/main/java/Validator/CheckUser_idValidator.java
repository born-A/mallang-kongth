package Validator;


import capjjangdol.mallangkongth.domain.repository.MemberRepository;
import capjjangdol.mallangkongth.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.internal.constraintvalidators.bv.number.bound.AbstractMinValidator;
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