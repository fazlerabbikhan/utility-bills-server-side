package com.fazlerabbikhan.utilitybillsserverside.serviceImpl;

import com.fazlerabbikhan.utilitybillsserverside.entity.CategoryEntity;
import com.fazlerabbikhan.utilitybillsserverside.model.response.CategoryResponse;
import com.fazlerabbikhan.utilitybillsserverside.repository.CategoryRepository;
import com.fazlerabbikhan.utilitybillsserverside.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryEntity createCategory(CategoryEntity categoryEntity) {
        return categoryRepository.save(categoryEntity);
    }

    @Override
    public CategoryResponse getCategoryById(long id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id);
        CategoryResponse categoryResponse = new CategoryResponse();
        if (categoryEntity != null) {
            categoryResponse.setOutCode("0");
            categoryResponse.setOutMessage("Category found successfully" );
            categoryResponse.setId(categoryEntity.getId());
            categoryResponse.setCode(categoryEntity.getCode());
            categoryResponse.setName(categoryEntity.getName());
            categoryResponse.setName_bn(categoryEntity.getName_bn());
            categoryResponse.setUtilities(categoryEntity.getUtilities());
        } else {
            categoryResponse.setOutCode("1");
            categoryResponse.setOutMessage("Category doesn't exist with ID " + id);
        }
        return categoryResponse;
    }

    @Override
    public CategoryResponse updateCategory(long id, CategoryEntity categoryEntity) {
        CategoryEntity existingCategory = categoryRepository.findById(id);
        CategoryResponse categoryResponse = new CategoryResponse();
        if (existingCategory != null) {
            existingCategory.setCode(categoryEntity.getCode());
            existingCategory.setName(categoryEntity.getName());
            existingCategory.setName_bn(categoryEntity.getName_bn());
            existingCategory.setUtilities(categoryEntity.getUtilities());
            categoryRepository.save(existingCategory);

            categoryResponse.setOutCode("0");
            categoryResponse.setOutMessage("Category updated successfully");
            categoryResponse.setId(existingCategory.getId());
            categoryResponse.setCode(existingCategory.getCode());
            categoryResponse.setName(existingCategory.getName());
            categoryResponse.setName_bn(existingCategory.getName_bn());
            categoryResponse.setUtilities(existingCategory.getUtilities());
        } else {
            categoryResponse.setOutCode("1");
            categoryResponse.setOutMessage("Category doesn't exist with ID " + id);
        }
        return categoryResponse;
    }

    @Override
    public String deleteCategory(long id) {
        categoryRepository.deleteById(id);
        return "User deleted successfully";
    }

}
