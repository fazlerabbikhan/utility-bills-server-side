package com.fazlerabbikhan.utilitybillsserverside.model.request;

import com.fazlerabbikhan.utilitybillsserverside.entity.FieldEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UtilityRequest {

    private String name;
    private String name_bn;
    private String code;
    private boolean billable;
    private String apis;
    private List<FieldEntity> fields;
}