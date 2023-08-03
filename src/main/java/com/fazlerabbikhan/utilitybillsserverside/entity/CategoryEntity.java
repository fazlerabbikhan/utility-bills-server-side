package com.fazlerabbikhan.utilitybillsserverside.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gpcategories")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String code;
    private String name;
    private String name_bn;

    @OneToMany(targetEntity = UtilityEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "categorycode", referencedColumnName = "code")
    private List<UtilityEntity> utilities;
}
