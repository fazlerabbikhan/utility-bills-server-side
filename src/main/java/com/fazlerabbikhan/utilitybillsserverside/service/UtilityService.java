package com.fazlerabbikhan.utilitybillsserverside.service;

import com.fazlerabbikhan.utilitybillsserverside.entity.UtilityEntity;
import com.fazlerabbikhan.utilitybillsserverside.model.response.UtilityResponse;

public interface UtilityService {

    UtilityEntity createUtility(UtilityEntity utilityEntity);
    UtilityResponse getUtilityById(long id);
    UtilityResponse updateUtility(long id, UtilityEntity utilityEntity);
    String deleteUtility(long id);
}
