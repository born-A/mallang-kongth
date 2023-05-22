//package capjjangdol.mallangkongth.service;
//
//import capjjangdol.mallangkongth.domain.mypage.Member;
//import capjjangdol.mallangkongth.repository.MemberRepository;
//import capjjangdol.mallangkongth.dto.MemberDto;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.List;
//@Slf4j
//@Service
//@Transactional
//public class MemberService {
//    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//    @Autowired
//    private MemberRepository memberRepository;
//
////    @Autowired
////    private Pet pet;
//
////    @Override
//    /**
//     * register
//     */
//    public Long join(MemberDto.RequestMemberDto dto){
//        dto.encryptPassword(encoder.encode(dto.getPw()));
//        Member member = dto.toEntity();
//        memberRepository.save(member);
//        log.info("db save successful");
//        return Long.valueOf(member.getUser_id());
//    }
//
//    @Transactional
////    @Override
//    public boolean checkUser_idDuplication(String user_id) {
//        boolean user_idDuplicate = memberRepository.existsByUser_id(user_id);
//        return user_idDuplicate;
//    }
//    /**
//     * login
//     */
//    private void validateDuplicateMember(Member member) {
//        List<Member> findMembers = memberRepository.findByUser_id(member.getUser_id());
//        if(!findMembers.isEmpty()){
//            throw new IllegalStateException("?? ???? ?????.");
//        }
//    }
//    public List<Member> findMembers() {
//        return memberRepository.findAll();
//    }
//    public Member findOne(Long memberId) {
//        return memberRepository.findOne(memberId);
//    }
//}
