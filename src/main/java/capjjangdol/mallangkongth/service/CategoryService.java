//package capjjangdol.mallangkongth.service;
//
//
//import capjjangdol.mallangkongth.domain.mypage.CategoryOfItem;
//import capjjangdol.mallangkongth.domain.mypage.Item;
//import capjjangdol.mallangkongth.repository.CategoryRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//
//@Service
//@RequiredArgsConstructor
//public class CategoryService {
//    private final CategoryRepository categoryRepository;
//
//    @Transactional
//    public void saveCategory(CategoryOfItem category) {
//        categoryRepository.save(category);
//    }
//    public List<CategoryOfItem> findCategories() {
//        return categoryRepository.findAll();
//    }
//
//    public CategoryOfItem findOne(Long categoryId) {
//        return categoryRepository.findById(categoryId).get();
//    }
//}
