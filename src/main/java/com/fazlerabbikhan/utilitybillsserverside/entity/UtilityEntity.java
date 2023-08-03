package com.fazlerabbikhan.utilitybillsserverside.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gputilities")
public class UtilityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String name_bn;
    private String code;
    private boolean billable;
    private String apis;

    @OneToMany(targetEntity = FieldEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "gputilitycode", referencedColumnName = "code")
    private List<FieldEntity> fields;
}