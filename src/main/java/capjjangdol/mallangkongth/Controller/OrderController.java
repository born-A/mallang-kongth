package capjjangdol.mallangkongth.Controller;

import capjjangdol.mallangkongth.domain.file.FileEntity;
import capjjangdol.mallangkongth.domain.mypage.*;
import capjjangdol.mallangkongth.repository.FileRepository;
import capjjangdol.mallangkongth.repository.MemberRepository;
import capjjangdol.mallangkongth.service.CategoryService;
import capjjangdol.mallangkongth.service.ItemService;
//import capjjangdol.mallangkongth.service.MemberService;
import capjjangdol.mallangkongth.service.MemberService;
import capjjangdol.mallangkongth.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final MemberService memberService;
    private final ItemService itemService;
    private final CategoryService categoryService;

    private final FileRepository fileRepository;

    @GetMapping(value = "/item/order/{id}")
    public String createForm(@SessionAttribute(name= SessionConst.LOGIN_MEMBER,required = false)Member member,@PathVariable("id") Long id,Model model) {
        List<Member> members = memberService.findAll();
        Item item = itemService.findOne(id);
        List<CategoryOfItem> categories = categoryService.findCategories();

        model.addAttribute("member", member);
        model.addAttribute("members", members);
        model.addAttribute("item", item);
        model.addAttribute("categories", categories); //카테고리
        List<FileEntity> files = fileRepository.findAll();
        model.addAttribute("all",files);
        return "order/orderForm";
    }

    @PostMapping(value = "/item/order/{id}")
        public String order(@SessionAttribute(name= SessionConst.LOGIN_MEMBER,required = false)Member member,
                            @PathVariable("id") Long itemId, @RequestParam("count") int count) {
        orderService.order(member.getId(), itemId, count);
        return "redirect:/order/list";
    }
    @GetMapping(value = "/order/list")
    public String orderList(Model model) {
        List<Orders> orders = orderService.findOrders();
        model.addAttribute("orders", orders);
        return "order/orderList";
    }
    @PostMapping(value = "/order/{orderId}/cancel")
    public String cancelOrder(@PathVariable("orderId") Long orderId) {
        orderService.cancelOrder(orderId);
        return "redirect:/order/list";
    }
}