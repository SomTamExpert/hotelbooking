package ch.bbw.km.hotelbooking.controller;

import ch.bbw.km.hotelbooking.model.Category;
import ch.bbw.km.hotelbooking.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;


    @GetMapping
    public Iterable<Category> getAllCategories() {
        return categoryService.getCategories();
    }
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable int id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    public Category createCategory(Category category) {
        return categoryService.createCategory(category);
    }

    @PutMapping("/{id}")
    public Category updateCategoryById(@PathVariable int id, Category category) {
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public void  deleteCategoryById(@PathVariable int id) {
        categoryService.deleteCategoryById(id);
    }
}
