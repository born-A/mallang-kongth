package capjjangdol.mallangkongth.Controller;

//import capjjangdol.mallangkongth.domain.mypage.ChangePwReqDto;
//import capjjangdol.mallangkongth.domain.mypage.MemberReqDto;
//import capjjangdol.mallangkongth.domain.mypage.MemberResDto;
//import capjjangdol.mallangkongth.service.MemberService;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/member")
//public class MemberController {
//    private final MemberService memberService;
//
//    @GetMapping("/me")
//    public ResponseEntity<MemberResDto> getMyMemberInfo() {
//        MemberResDto myInfoBySecurity = memberService.getMyInfoBySecurity();
//        System.out.println(myInfoBySecurity.getName());
//        return ResponseEntity.ok((myInfoBySecurity));
//        // return ResponseEntity.ok(memberService.getMyInfoBySecurity());
//    }
//
//    @PostMapping("/name")
//    public ResponseEntity<MemberResDto> setMemberName(@RequestBody MemberReqDto req) {
//        return ResponseEntity.ok(memberService.changeMembername(req.getEmail(), req.getName()));
//    }
//
//    @PostMapping("/pw")
//    public ResponseEntity<MemberResDto> setMemberPw(@RequestBody ChangePwReqDto request) {
//        return ResponseEntity.ok(memberService.changeMemberPw(request.getExPw(), request.getNewPw()));
//    }
//
//}


import capjjangdol.mallangkongth.domain.file.FileEntity;
import capjjangdol.mallangkongth.domain.mypage.Address;
import capjjangdol.mallangkongth.domain.mypage.Member;
import capjjangdol.mallangkongth.domain.mypage.MemberDto;
import capjjangdol.mallangkongth.domain.mypage.MemberForm;
import capjjangdol.mallangkongth.repository.FileRepository;
import capjjangdol.mallangkongth.service.FileService;
import capjjangdol.mallangkongth.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final FileService fileService;
    private final FileRepository fileRepository;


    @GetMapping("/members/new")
    public String createForm(Model model){
        model.addAttribute("memberForm", new MemberForm());
        return "members/sign-up";
    }

    @PostMapping("/members/new")
    public String create(@Valid MemberForm form, BindingResult result){
        if(result.hasErrors()){
            return "members/sign-up";
        }
        Address address = Address.createAddress(form.getCity(), form.getStreet(), form.getZipcode());
        Member member = Member.createMember(form.getEmail(), form.getPassword(), form.getUsername(),address);
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(@PageableDefault(size = 8)Pageable pageable, Model model){
        pageable.getSort();
        Page<MemberDto> page = memberService.findAll(pageable);
        model.addAttribute("members", page);
        return "/members/memberList";
    }

    @GetMapping("/member/info")
    public String updateMemberForm(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false)Long memberId, Model model){
        Member findMember = memberService.findOne(memberId);
        MemberForm form = MemberForm.createMemberForm(findMember);
        model.addAttribute("member",findMember);
        model.addAttribute("memberForm", form);
        List<FileEntity> files = fileRepository.findAll();
        model.addAttribute("all",files);
        return "members/account-profile";
    }

    @PostMapping("/member/edit")
    public String updateMember(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false)Long memberId,
                               @Valid @ModelAttribute("memberForm")MemberForm form,
                               BindingResult bindingResult,
                               HttpServletRequest request,
                               @RequestParam("file") MultipartFile file)throws IOException {
        // MemberForm 에 email 혹은 password 의 값이 존재하지 않을 때
        if (bindingResult.hasErrors()) {
            return "/members/memberInfo";
        }

        memberService.updateMember(memberId, form.getEmail(), form.getPassword(), form.getUsername(), form.getCity(), form.getStreet(), form.getZipcode(), request);
        fileService.saveFile(file);

        return "redirect:/member/info";
    }

    @GetMapping("/member/delete")
    public String membersDelete(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false)Long memberId){
        memberService.deleteById(memberId);
        return "redirect:/";
    }
}
