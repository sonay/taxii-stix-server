package com.example.stix.serialization.jackson;

import com.example.stix.api.BundleObject;
import com.example.stix.api.StixType;
import com.example.stix.api.datatypes.Identifier;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

import static com.example.stix.api.Bundle.*;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;


@JsonAutoDetect(fieldVisibility = NONE, getterVisibility = NONE, isGetterVisibility = NONE)
@JsonPropertyOrder({TYPE_PROPERTY, ID_PROPERTY, SPEC_VERSION_PROPERTY, OBJECTS_PROPERTY})
public abstract class BundleMixin {

    @JsonCreator BundleMixin(@JsonProperty(value = TYPE_PROPERTY, required = true) StixType type,
                             @JsonProperty(value = ID_PROPERTY, required = true) Identifier id,
                             @JsonProperty(value = SPEC_VERSION_PROPERTY, required = true) String specVersion,
                             @JsonProperty(OBJECTS_PROPERTY) List<BundleObject> objects) {
        throw new AssertionError("DO NOT INSTANTIATE, THIS IS AN INTERFACE");
    }

    @JsonProperty(TYPE_PROPERTY) abstract StixType getType();

    @JsonProperty(SPEC_VERSION_PROPERTY) abstract String getSpecVersion();

    @JsonProperty(ID_PROPERTY) abstract Identifier getId();

    @JsonProperty(OBJECTS_PROPERTY) abstract List<BundleObject> getObjects();

}