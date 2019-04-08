package com.example.stix.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.Version;
import java.io.Serializable;
import java.util.UUID;

@Data
@RequiredArgsConstructor
@Embeddable
public class Identifier implements Serializable {

    @Id
    private Long pk;

    @NaturalId
    private UUID id;

    @Version
    @Column(insertable = false)
    private Integer version;

}
