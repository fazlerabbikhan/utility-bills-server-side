package com.fazlerabbikhan.utilitybillsserverside.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gpfields")
public class FieldEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
