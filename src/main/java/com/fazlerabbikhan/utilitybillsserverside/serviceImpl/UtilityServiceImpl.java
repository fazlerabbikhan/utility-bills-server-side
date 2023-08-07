package com.fazlerabbikhan.utilitybillsserverside.serviceImpl;

import com.fazlerabbikhan.utilitybillsserverside.entity.UtilityEntity;
import com.fazlerabbikhan.utilitybillsserverside.model.response.UtilityResponse;
import com.fazlerabbikhan.utilitybillsserverside.repository.UtilityRepository;
import com.fazlerabbikhan.utilitybillsserverside.service.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilityServiceImpl implements UtilityService {

    @Autowired
    private UtilityRepository utilityRepository;

    @Override
    public UtilityEntity createUtility(UtilityEntity utilityEntity) {
        return utilityRepository.save(utilityEntity);
    }

    @Override
    public UtilityResponse getUtilityById(long id) {
        UtilityEntity utilityEntity = utilityRepository.findById(id);
        UtilityResponse utilityResponse = new UtilityResponse();
        if (utilityEntity != null) {
            utilityResponse.setOutCode("0");
            utilityResponse.setOutMessage("Utility found successfully" );
            utilityResponse.setId(utilityEntity.getId());
            utilityResponse.setName(utilityEntity.getName());
            utilityResponse.setName_bn(utilityEntity.getName_bn());
            utilityResponse.setCode(utilityEntity.getCode());
            utilityResponse.setBillable(utilityEntity.isBillable());
            utilityResponse.setApis(utilityEntity.getApis());
            utilityResponse.setFields(utilityEntity.getFields());
        } else {
            utilityResponse.setOutCode("1");
            utilityResponse.setOutMessage("Utility doesn't exist with ID " + id);
        }
        return utilityResponse;
    }

    @Override
    public UtilityResponse updateUtility(long id, UtilityEntity utilityEntity) {
        UtilityEntity existingUtility = utilityRepository.findById(id);
        UtilityResponse utilityResponse = new UtilityResponse();
        if (existingUtility != null) {
            existingUtility.setName(utilityEntity.getName());
            existingUtility.setName_bn(utilityEntity.getName_bn());
            existingUtility.setCode(utilityEntity.getCode());
            existingUtility.setBillable(utilityEntity.isBillable());
            existingUtility.setApis(utilityEntity.getApis());
            existingUtility.setFields(utilityEntity.getFields());
            utilityRepository.save(existingUtility);

            utilityResponse.setOutCode("0");
            utilityResponse.setOutMessage("Utility updated successfully");
            utilityResponse.setId(existingUtility.getId());
            utilityResponse.setName(existingUtility.getName());
            utilityResponse.setName_bn(existingUtility.getName_bn());
            utilityResponse.setCode(existingUtility.getCode());
            utilityResponse.setBillable(existingUtility.isBillable());
            utilityResponse.setApis(existingUtility.getApis());
            utilityResponse.setFields(existingUtility.getFields());
        } else {
            utilityResponse.setOutCode("1");
            utilityResponse.setOutMessage("Utility doesn't exist with ID " + id);
        }
        return utilityResponse;
    }

    @Override
    public String deleteUtility(long id) {
        utilityRepository.deleteById(id);
        return "Utility deleted successfully";
    }

}