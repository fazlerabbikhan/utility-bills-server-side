package com.fazlerabbikhan.utilitybillsserverside.controller;

import com.fazlerabbikhan.utilitybillsserverside.entity.CategoryEntity;
import com.fazlerabbikhan.utilitybillsserverside.model.response.CategoryResponse;
import com.fazlerabbikhan.utilitybillsserverside.repository.CategoryRepository;
import com.fazlerabbikhan.utilitybillsserverside.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    //Get all categories
    @GetMapping("all")
    public List<CategoryEntity> getAllCategories(){
        return categoryRepository.findAll();
    }

    //Create a category
    @PostMapping("save")
    public CategoryEntity createCategory(@RequestBody CategoryEntity categoryEntity){
        return categoryService.createCategory(categoryEntity);
    }

    //Get a category by ID
    @GetMapping("{id}")
    public CategoryResponse getCategoryById(@PathVariable long id){
        return categoryService.getCategoryById(id);
    }

    // Update a category
    @PutMapping("{id}")
    public CategoryResponse updateCategory(@PathVariable long id, @RequestBody CategoryEntity categoryEntity) {
        return categoryService.updateCategory(id, categoryEntity);
    }

    // Delete a category
    @DeleteMapping("{id}")
    public String deleteCategory(@PathVariable long id) {
        return categoryService.deleteCategory(id);
    }

}
