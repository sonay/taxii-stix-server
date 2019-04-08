package com.example.taxii.rest.impl.service;

import com.example.taxii.rest.api.datatypes.CollectionResource;
import com.example.taxii.rest.api.datatypes.CollectionsResource;
import com.example.taxii.rest.impl.objects.Range;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CollectionsServiceImpl implements CollectionsService {

    @Override
    public CollectionsResource getAllCollections(String apiRoot, Range range) {
        return null;
    }

    @Override
    public CollectionResource getCollection(UUID collectionId) {
        return null;
    }
}
