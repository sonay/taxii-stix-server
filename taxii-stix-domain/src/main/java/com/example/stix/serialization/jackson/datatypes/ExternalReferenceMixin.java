package com.example.stix.serialization.jackson.datatypes;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Map;

import static com.example.stix.api.datatypes.ExternalReference.*;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@JsonAutoDetect(fieldVisibility = NONE, getterVisibility = NONE, isGetterVisibility = NONE)
@JsonPropertyOrder({SOURCE_NAME_PROPERTY, URL_PROPERTY, HASHES_PROPERTY, DESCRIPTION_PROPERTY, EXTERNAL_ID_PROPERTY})
public abstract class ExternalReferenceMixin {

    @JsonProperty(SOURCE_NAME_PROPERTY) abstract String getSourceName();

    @JsonProperty(DESCRIPTION_PROPERTY) abstract String getDescription();

    @JsonProperty(URL_PROPERTY) abstract String getUrl();

    @JsonProperty(HASHES_PROPERTY) abstract Map<String, String> getHashes();

    @JsonProperty(EXTERNAL_ID_PROPERTY) abstract String getExternalId();

}
