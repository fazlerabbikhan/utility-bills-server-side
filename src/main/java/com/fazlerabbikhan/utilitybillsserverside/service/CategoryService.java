package com.fazlerabbikhan.utilitybillsserverside.service;

import com.fazlerabbikhan.utilitybillsserverside.entity.CategoryEntity;
import com.fazlerabbikhan.utilitybillsserverside.model.response.CategoryResponse;

public interface CategoryService {

    CategoryEntity createCategory(CategoryEntity categoryEntity);
    CategoryResponse getCategoryById(long id);
    CategoryResponse updateCategory(long id, CategoryEntity categoryEntity);
    String deleteCategory(long id);
}
