package capjjangdol.mallangkongth.service;


import capjjangdol.mallangkongth.domain.mypage.Item;
import capjjangdol.mallangkongth.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }
    public List<Item> findItems() {
        return itemRepository.findAll();
    }
    public Item findOne(Long itemId) {
        return itemRepository.findById(itemId).get();
    }

    @Transactional
    public void updateItem(Long id, String name, int price) {
        Item item = itemRepository.findById(id).get();
        item.setName(name);
        item.setPrice(price);
    }
}