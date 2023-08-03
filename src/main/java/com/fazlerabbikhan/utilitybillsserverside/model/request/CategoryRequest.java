package com.fazlerabbikhan.utilitybillsserverside.model.request;

import com.fazlerabbikhan.utilitybillsserverside.entity.UtilityEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequest {

    private String code;
    private String name;
    private String name_bn;
    private List<UtilityEntity> utilities;
}
