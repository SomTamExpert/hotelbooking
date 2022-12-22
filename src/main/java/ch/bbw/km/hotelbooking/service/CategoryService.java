package ch.bbw.km.hotelbooking.service;

import ch.bbw.km.hotelbooking.model.Category;
import ch.bbw.km.hotelbooking.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Iterable<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(int id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category with id " + id + " not found"));
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(int id, Category category) {
        Category categoryToUpdate = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category with id " + id + " not found"));
        categoryToUpdate.setDescription(category.getDescription());
        categoryToUpdate.setRating(category.getRating());
        categoryToUpdate.setTitle(category.getTitle());
        categoryToUpdate.setRooms(category.getRooms());
        return categoryRepository.save(categoryToUpdate);
    }
}
