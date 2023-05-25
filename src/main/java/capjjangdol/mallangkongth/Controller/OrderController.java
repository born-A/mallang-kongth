package capjjangdol.mallangkongth.Controller;

import capjjangdol.mallangkongth.domain.mypage.*;
import capjjangdol.mallangkongth.service.CategoryService;
import capjjangdol.mallangkongth.service.ItemService;
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

    @GetMapping(value = "/order/new")
    public String createForm(Model model) {
        List<Member> members = memberService.findMembers();
        List<Item> items = itemService.findItems();
        List<CategoryOfItem> categories = categoryService.findCategories();
        model.addAttribute("members", members);
        model.addAttribute("items", items);
        model.addAttribute("categories", categories); //카테고리
        return "order/orderForm";
    }

    //회원 세션 받도록 수정
    @PostMapping(value = "/order/new")
    public String order(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member member,
                        @RequestParam("itemId") Long itemId, @RequestParam("count") int count) {
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