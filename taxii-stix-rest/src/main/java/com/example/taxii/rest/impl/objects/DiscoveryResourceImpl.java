package com.example.taxii.rest.impl.objects;

import com.example.taxii.rest.api.datatypes.DiscoveryResource;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DiscoveryResourceImpl implements DiscoveryResource {

    private final String title;

    private final String description;

    private final String contact;

    private final String defaultRoot;

    private final List<String> apiRoots;


    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getContact() {
        return contact;
    }

    @Override
    public String getDefault() {
        return defaultRoot;
    }

    @Override
    public List<String> getApiRoots() {
        return apiRoots;
    }
}
