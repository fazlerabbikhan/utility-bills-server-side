package com.fazlerabbikhan.utilitybillsserverside.service;

import com.fazlerabbikhan.utilitybillsserverside.entity.FieldEntity;
import com.fazlerabbikhan.utilitybillsserverside.model.response.FieldResponse;

public interface FieldService {

    FieldEntity createField(FieldEntity fieldEntity);
    FieldResponse getFieldById(long id);
    FieldResponse updateField(long id, FieldEntity fieldEntity);
    String deleteField(long id);
}