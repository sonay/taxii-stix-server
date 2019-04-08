package com.example.taxii.rest.impl.endpoints;

import com.example.stix.api.Bundle;
import com.example.stix.api.datatypes.Identifier;
import com.example.taxii.rest.api.datatypes.CollectionResource;
import com.example.taxii.rest.api.datatypes.CollectionsResource;
import com.example.taxii.rest.api.datatypes.ManifestResource;
import com.example.taxii.rest.api.datatypes.StatusResource;
import com.example.taxii.rest.api.endpoints.CollectionsEndpoint;
import com.example.taxii.rest.impl.service.CollectionsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Pattern;

import static com.example.taxii.rest.api.MediaTypes.STIX_VERSION_2_0;
import static com.example.taxii.rest.api.MediaTypes.TAXII_VERSION_2_0;

@RestController
@RequestMapping(path = "/roots/{api-root}/collections")
public class CollectionsEndpointImpl implements CollectionsEndpoint {

    // expected range header value format = items int - int
    private static final Pattern RANGE_PATTERN = Pattern.compile("\\s*items\\s*\\d-\\d\\s*");

    private int defaultPaginationSize;

    private CollectionsService collectionService;

    private ObjectMapper mapper;

    public CollectionsEndpointImpl(CollectionsService cs, ObjectMapper mapper) {
        this.collectionService = Objects.requireNonNull(cs);
        this.mapper = Objects.requireNonNull(mapper);
    }

    @Override
    @GetMapping(produces = TAXII_VERSION_2_0)
    public ResponseEntity<CollectionsResource> getCollections(
            @PathVariable("api-root") String apiRoot,
            @RequestHeader(value = HttpHeaders.RANGE, required = false) String range) {
        return null;
    }

    @Override
    @GetMapping(path = "/{collectionId}", produces = TAXII_VERSION_2_0)
    public CollectionResource getCollection(@PathVariable("api-root") String apiRoot,
                                            @PathVariable("collectionId") UUID collectionId) {
        return null;
    }

    @Override
    @GetMapping(path = "/{collectionId}/objects", produces = STIX_VERSION_2_0)
    public Bundle getObjects(@PathVariable("api-root") String apiRoot,
                             @PathVariable("collectionId") UUID collectionId,
                             @RequestHeader(value = HttpHeaders.RANGE, required = false) String rangeHeader,
                             @RequestParam(value = "added_after", required = false)
                             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime addedAfter,
                             @RequestParam(value = "match[id]", required = false) Set<Identifier> ids,
                             @RequestParam(value = "match[type]", required = false) Set<String> types,
                             @RequestParam(value = "match[version]", required = false) String version) {

        return null;
    }

    @Override
    @PostMapping(path = "/{collectionId}/objects", consumes = STIX_VERSION_2_0, produces = TAXII_VERSION_2_0)
    public StatusResource addObjects(@PathVariable("api-root") String apiRoot,
                                     @PathVariable("collectionId") UUID collectionId,
                                     @Valid @RequestBody Bundle bundle) {

        return null;
    }

    @Override
    @GetMapping(path = "/{collectionId}/object/{objectId}", produces = STIX_VERSION_2_0)
    public Bundle getObject(@PathVariable("api-root") String apiRoot,
                            @PathVariable("collectionId") UUID collectionId,
                            @PathVariable("objectId") Identifier objectId,
                            @RequestParam(value = "match[version]", required = false) String version) {
        return null;
    }


    @Override
    @GetMapping(path = "/{collectionId}/manifest", produces = TAXII_VERSION_2_0)
    public ManifestResource getManifest(@PathVariable("api-root") String apiRoot,
                                        @PathVariable("collectionId") UUID collectionId,
                                        @RequestParam(value = "match[id]", required = false) Set<Identifier> ids,
                                        @RequestParam(value = "match[type]", required = false) Set<String> types,
                                        @RequestParam(value = "match[version]", required = false) String version) {
        return null;
    }
}
