package com.fazlerabbikhan.utilitybillsserverside.serviceImpl;

import com.fazlerabbikhan.utilitybillsserverside.entity.FieldEntity;
import com.fazlerabbikhan.utilitybillsserverside.model.response.FieldResponse;
import com.fazlerabbikhan.utilitybillsserverside.repository.FieldRepository;
import com.fazlerabbikhan.utilitybillsserverside.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FieldServiceImpl implements FieldService {

    @Autowired
    private FieldRepository fieldRepository;

    @Override
    public FieldEntity createField(FieldEntity fieldEntity) {
        return fieldRepository.save(fieldEntity);
    }

    @Override
    public FieldResponse getFieldById(long id) {
        FieldEntity fieldEntity = fieldRepository.findById(id);
        FieldResponse fieldResponse = new FieldResponse();
        if (fieldEntity != null) {
            fieldResponse.setOutCode("0");
            fieldResponse.setOutMessage("Field found successfully" );
            fieldResponse.setId(fieldEntity.getId());
            fieldResponse.setCode(fieldEntity.getCode());
            fieldResponse.setType(fieldEntity.getType());
            fieldResponse.setRequired(fieldEntity.isRequired());
            fieldResponse.setDefaultValue(fieldEntity.getDefaultValue());
            fieldResponse.setOptions(fieldEntity.getOptions());
            fieldResponse.setRegex(fieldEntity.getRegex());
            fieldResponse.setConfig(fieldEntity.getConfig());
            fieldResponse.setLabel(fieldEntity.getLabel());
        } else {
            fieldResponse.setOutCode("1");
            fieldResponse.setOutMessage("Field doesn't exist with ID " + id);
        }
        return fieldResponse;
    }

    @Override
    public FieldResponse updateField(long id, FieldEntity fieldEntity) {
        FieldEntity existingField = fieldRepository.findById(id);
        FieldResponse fieldResponse = new FieldResponse();
        if (existingField != null) {
            existingField.setCode(fieldEntity.getCode());
            existingField.setCode(fieldEntity.getCode());
            existingField.setCode(fieldEntity.getCode());
            existingField.setType(fieldEntity.getType());
            existingField.setRequired(fieldEntity.isRequired());
            existingField.setDefaultValue(fieldEntity.getDefaultValue());
            existingField.setOptions(fieldEntity.getOptions());
            existingField.setRegex(fieldEntity.getRegex());
            existingField.setConfig(fieldEntity.getConfig());
            existingField.setLabel(fieldEntity.getLabel());
            fieldRepository.save(existingField);

            fieldResponse.setOutCode("0");
            fieldResponse.setOutMessage("Field updated successfully");
            fieldResponse.setId(existingField.getId());
            fieldResponse.setCode(existingField.getCode());
            fieldResponse.setType(existingField.getType());
            fieldResponse.setRequired(existingField.isRequired());
            fieldResponse.setDefaultValue(existingField.getDefaultValue());
            fieldResponse.setOptions(existingField.getOptions());
            fieldResponse.setRegex(existingField.getRegex());
            fieldResponse.setConfig(existingField.getConfig());
            fieldResponse.setLabel(existingField.getLabel());
        } else {
            fieldResponse.setOutCode("1");
            fieldResponse.setOutMessage("Field doesn't exist with ID " + id);
        }
        return fieldResponse;
    }

    @Override
    public String deleteField(long id) {
        fieldRepository.deleteById(id);
        return "Field deleted successfully";
    }

}
