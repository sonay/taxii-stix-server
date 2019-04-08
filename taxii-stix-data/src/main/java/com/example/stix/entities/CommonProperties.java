package com.example.stix.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import java.time.ZonedDateTime;
import java.util.List;

@MappedSuperclass
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@IdClass(Identifier.class)
public class CommonProperties {

    @EmbeddedId
    private final Identifier id;

    private final ZonedDateTime created;

    private final ZonedDateTime modified;

    private final Identifier createdByRef;

    private final boolean revoked;

    private final List<ExternalReference> externalReferences;

    private final List<GranularMarking> granularMarkingRefs;

    private final List<Identifier> objectMarkingRefs;

    private final List<String> labels;

}
