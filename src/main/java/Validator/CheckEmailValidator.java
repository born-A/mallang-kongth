//package Validator;
//
//
//import capjjangdol.mallangkongth.domain.mypage.JoinForm;
//import capjjangdol.mallangkongth.repository.MemberRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//@RequiredArgsConstructor
//@Component
//public class CheckEmailValidator extends AbstractValidator<JoinForm> {
//    private final MemberRepository memberRepository;
//
//    @Override
//    protected void doValidate(JoinForm form, Errors errors) {
//        if (memberRepository.existsByEmail(form.toEntity().getEmail())) {
//            errors.rejectValue("email","??? ?? ??", "?? ?? ?? ??????.");
//        }
//    }
//}