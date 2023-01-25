package ch.bbw.km.hotelbooking.controller;

import ch.bbw.km.hotelbooking.model.Category;
import ch.bbw.km.hotelbooking.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Class CategoryController
 * @author Marco Karpf
 * @version 25.01.2023
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    /**
     * get all categories
     * @return Iterable<Category>
     */
    @GetMapping
    public Iterable<Category> getAllCategories() {
        return categoryService.getCategories();
    }

    /**
     * get category by id
     * @param id
     * @return category
     */
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable int id) {
        return categoryService.getCategoryById(id);
    }

    /**
     * create category
     * @param category
     * @return category
     */
    @PostMapping
    public Category createCategory(Category category) {
        return categoryService.createCategory(category);
    }

    /**
     * update category
     * @param id
     * @param category
     * @return category
     */
    @PutMapping("/{id}")
    public Category updateCategoryById(@PathVariable int id, Category category) {
        return categoryService.updateCategory(id, category);
    }

    /**
     * delete category by id
     * @param id
     */
    @DeleteMapping("/{id}")
    public void  deleteCategoryById(@PathVariable int id) {
        categoryService.deleteCategoryById(id);
    }
}
