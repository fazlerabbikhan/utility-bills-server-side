package com.fazlerabbikhan.utilitybillsserverside.repository;

import com.fazlerabbikhan.utilitybillsserverside.entity.FieldEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FieldRepository extends JpaRepository<FieldEntity, Long> {

    FieldEntity findById(long id);
    void deleteById(long id);
}
