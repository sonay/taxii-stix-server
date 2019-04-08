package com.example.taxii.rest.impl.service;

import com.example.taxii.rest.api.datatypes.CollectionResource;
import com.example.taxii.rest.api.datatypes.CollectionsResource;
import com.example.taxii.rest.impl.objects.Range;

import java.util.UUID;

public interface CollectionsService {

    CollectionsResource getAllCollections(String apiRoot, Range range);

    CollectionResource getCollection(UUID collectionId);

}
