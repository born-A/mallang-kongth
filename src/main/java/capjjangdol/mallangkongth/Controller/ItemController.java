package capjjangdol.mallangkongth.Controller;

import capjjangdol.mallangkongth.domain.file.FileEntity;
import capjjangdol.mallangkongth.domain.mypage.Item;
import capjjangdol.mallangkongth.domain.mypage.ItemForm;
import capjjangdol.mallangkongth.domain.mypage.Member;
import capjjangdol.mallangkongth.domain.mypage.WaterBowlItem;
import capjjangdol.mallangkongth.repository.FileRepository;
import capjjangdol.mallangkongth.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    private final FileRepository fileRepository;
    @GetMapping(value = "/item/new")
    public String createForm(Model model, @SessionAttribute(name= SessionConst.LOGIN_MEMBER,required = false) Member member) {
        model.addAttribute("form", new ItemForm());
        model.addAttribute("member",member);
        List<FileEntity> files = fileRepository.findAll();
        model.addAttribute("all",files);
        return "item/createItemForm";
    }
    @PostMapping(value = "/item/new")
    public String create(ItemForm form) {
        WaterBowlItem waterBowlItem = new WaterBowlItem();
        waterBowlItem.setName(form.getName());
        waterBowlItem.setPrice(form.getPrice());
        waterBowlItem.setStockQuantity(form.getStockQuantity());
        itemService.saveItem(waterBowlItem);
        return "redirect:/item/list";
    }


    /**
     *상품 수정
     */
    @PostMapping(value = "/item/{itemId}/edit")
    public String updateItem(@PathVariable Long itemId,@ModelAttribute("form") ItemForm form) {
        itemService.updateItem(itemId, form);
        return "redirect:/item/list";
    }

    /**
     * 상품 목록
     */
    @GetMapping(value = "/item/list")
    public String list(Model model) {
        List<Item> items = itemService.findItems();
        model.addAttribute("items", items);
        return "item/item-directory";
    }

    /**
     * 상품 수정 폼
     */
    @GetMapping(value = "/item/{itemId}/edit")
    public String updateItemForm(@PathVariable("itemId") Long itemId, Model model) {
        WaterBowlItem item = (WaterBowlItem) itemService.findOne(itemId);
        ItemForm form = new ItemForm();
        form.setId(item.getId());
        form.setName(item.getName());
        form.setPrice(item.getPrice());
        form.setStockQuantity(item.getStockQuantity());
        model.addAttribute("form", form);
        return "item/updateItemForm";
    }

//    /**
//     * 상품 수정
//     */
//    @PostMapping(value = "/item/{itemId}/edit")
//    public String updateItem(@ModelAttribute("form") ItemForm form) {
//        WaterBowlItem waterBowlItem = new WaterBowlItem();
//        waterBowlItem.setId(form.getId());
//        waterBowlItem.setName(form.getName());
//        waterBowlItem.setPrice(form.getPrice());
//        waterBowlItem.setStockQuantity(form.getStockQuantity());
//        itemService.saveItem(waterBowlItem);
//        return "redirect:/item";
//    }

}
