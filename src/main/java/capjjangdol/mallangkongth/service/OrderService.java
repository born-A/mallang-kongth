package capjjangdol.mallangkongth.service;

import capjjangdol.mallangkongth.domain.mypage.*;
import capjjangdol.mallangkongth.repository.ItemRepository;
import capjjangdol.mallangkongth.repository.MemberRepository;
import capjjangdol.mallangkongth.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {
    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    @Transactional
    public Long order(Long memberId, Long itemId, int count) {
        Member member = memberRepository.findById(memberId).get();
        Item item = itemRepository.findById(itemId).get();

        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());
        delivery.setStatus(DeliveryStatus.READY);

        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(),count);

        Orders order = Orders.createOrder(member, delivery, orderItem);
        orderRepository.save(order);
        return order.getId();
    }

    @Transactional
    public void cancelOrder(Long orderId) {
        Orders order = orderRepository.findById(orderId).get();
        order.cancel();
    }
    public List<Orders> findOrders() {
        return orderRepository.findAll();
    }

//    public List <Orders> findOrders(OrderSearch orderSearch) {
//        return orderRepository.findAll(orderSearch);
//    }
}