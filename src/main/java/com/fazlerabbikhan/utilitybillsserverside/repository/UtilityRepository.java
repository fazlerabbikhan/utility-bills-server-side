package com.fazlerabbikhan.utilitybillsserverside.repository;

import com.fazlerabbikhan.utilitybillsserverside.entity.UtilityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilityRepository extends JpaRepository<UtilityEntity, Long> {

    UtilityEntity findById(long id);
    void deleteById(long id);
}