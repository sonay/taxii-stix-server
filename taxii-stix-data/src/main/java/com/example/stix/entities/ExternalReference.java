package com.example.stix.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@Data
@RequiredArgsConstructor
public class ExternalReference {

    private final String sourceName;

    private final String description;

    private final String url;

    private final Map<String, String> hashes;

    private final String externalId;

}
