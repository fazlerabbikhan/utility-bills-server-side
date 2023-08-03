package com.fazlerabbikhan.utilitybillsserverside.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FieldResponse {

    private String outCode = "";
    private String outMessage = "";
    private long id;
    private String code;
    private String type;
    private boolean required;
    private String defaultValue;
    private String options;
    private String regex;
    private String config;
    private String label;
}
