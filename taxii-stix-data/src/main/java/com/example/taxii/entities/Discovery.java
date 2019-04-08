package com.example.taxii.entities;

import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity(name = "discovery")
@Data
public class Discovery {

    @Id
    private final Long id;

    @NotBlank
    private final String title;

    private final String description;

    private final String contact;

    private final String defaultRoot;

    @ElementCollection(targetClass = String.class)
    private final List<String> apiRoots;

}
