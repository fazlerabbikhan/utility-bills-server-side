package com.fazlerabbikhan.utilitybillsserverside.repository;

import com.fazlerabbikhan.utilitybillsserverside.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    CategoryEntity findById(long id);
    void deleteById(long id);
}
