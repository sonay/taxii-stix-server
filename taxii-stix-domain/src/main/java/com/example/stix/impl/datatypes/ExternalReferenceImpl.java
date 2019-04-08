package com.example.stix.impl.datatypes;

import com.example.stix.api.datatypes.ExternalReference;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
// Because ExternalReference objects do not serialize their type information, Jackson needs a no args constructor to
// deserialize
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class ExternalReferenceImpl implements ExternalReference {

    private final String sourceName;

    private final String description;

    private final String url;

    private final Map<String, String> hashes;

    private final String externalId;

    public ExternalReferenceImpl(String sourceName) {
        this(sourceName, null, null, null, null);
    }

    public ExternalReferenceImpl(String sourceName, String description, String url, Map<String, String> hashes,
                                 String externalId) {
        this.sourceName = sourceName;
        this.description = description;
        this.url = url;
        this.hashes = hashes;
        this.externalId = externalId;
    }

    // REQUIRED PROPERTIES

    @Override
    public String getSourceName() {
        return sourceName;
    }

    // OPTIONAL PROPERTIES

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public Map<String, String> getHashes() {
        return hashes;
    }

    @Override
    public String getExternalId() {
        return externalId;
    }

}
