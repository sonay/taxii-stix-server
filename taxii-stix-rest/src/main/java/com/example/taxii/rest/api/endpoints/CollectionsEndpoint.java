package com.example.taxii.rest.api.endpoints;

import com.example.stix.api.Bundle;
import com.example.stix.api.datatypes.Identifier;
import com.example.taxii.rest.api.CustomHeaders;
import com.example.taxii.rest.api.datatypes.CollectionResource;
import com.example.taxii.rest.api.datatypes.CollectionsResource;
import com.example.taxii.rest.api.datatypes.ManifestResource;
import com.example.taxii.rest.api.datatypes.StatusResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;

import static java.time.ZoneOffset.UTC;


/*
* SORTING
*
* For the Collection and Manifest Endpoints, datatypes MUST be sorted in ascending order by the date the object first
* appeared in the TAXII Collection (i.e., the added date). The most recently added object is last in the list.
*
* For the Object Search Endpoint, datatypes MUST be sorted in ascending order by the date the object first appeared in
* object search (i.e., the added date). If an object would appear multiple times, all appearances after the first
* appearance MUST be omitted from the result. That is, if an object would have appeared first in the list and again
* halfway down, only the first entry should be present in the result.
*
* For the Collections Endpoint, Collections MUST be sorted and MAY be sorted in any order. Pagination requires a
* consistent sort order, and therefore multiple responses from the same endpoint need to be sorted in a consistent
* manner. Sort order MUST be consistent across responses.
*
* PAGINATION
* 
* Pagination is a feature that is used to break up result sets over multiple request/response pairs. TAXII uses
* HTTP's Range and Content-Range headers, and defines the items range unit, to perform pagination as defined in
* section 2 of [RFC7233]. items is the mandatory to implement range unit for TAXII. Other range units MAY be
* implemented by clients and servers.
* */

public interface CollectionsEndpoint {

    /*
    * This Endpoint provides information about the Collections hosted under this API Root. This is similar to the
    * response to get a Collection (see section 5.2), but rather than providing information about one Collection it
    * provides information about all of the Collections. Most importantly, it provides the Collection's id, which is
    * used to request datatypes or manifest entries from the Collection.
    *
    * Supported Method      GET
    * URL                   /<api-root>/collections/
    * Parameters            <api-root> - the base URL of the API Root containing the Collections
    * Pagination            Yes
    * Filtering             No
    * Valid Request Type    Accept: application/vnd.oasis.taxii+json; version=2.0
    *
    * Successful Response   Status: 200 (OK)
    *                       Content-Type: application/vnd.oasis.taxii+json; version=2.0
    *                       Body: collections
    *
    * Common Error Codes    404 - The Collections resource does not exist or the client does not have access to the
    *                       Collections resource.
    *                       401, 403 - The client either needs to authenticate or does not have access to get
    *                       Collection information.
    * */
    ResponseEntity<CollectionsResource> getCollections(String apiRoot, String rangeHeader);



    /*
    * This Endpoint provides general information about a Collection, which can be used to help users and clients
    * decide whether and how they want to interact with it. For example, it will tell clients what it's called and
    * what permissions they have to it.
    *
    * Supported Method      GET
    * URL                   /<api-root>/collections/<id>/
    *
    * Parameters            <api-root> - the base URL of the API Root containing the Collection
    *                       <id> - the identifier of the Collection being requested
    *
    * Pagination            No
    * Filtering             No
    * Valid Request Type    Accept: application/vnd.oasis.taxii+json; version=2.0
    *
    * Successful Response   Status: 200 (OK)
    *                       Content-Type: application/vnd.oasis.taxii+json; version=2.0
    *                       Body: collection
    *
    * Common Error Codes    404 - The Collection could not be found or the requester does not have access to get
    *                       Collection information.
    *                       401, 403 - The client either needs to authenticate or does not have access to get
    *                       Collection information.
    * */
    CollectionResource getCollection(String apiRoot, UUID collectionId);

    /*
    * This Endpoint retrieves datatypes from a Collection. Clients can search for datatypes in the Collection, retrieve
    * all datatypes in a Collection, or paginate through datatypes in the Collection.
    *
    * To support searching the Collection, the Endpoint supports filtering as defined in section 3.5. Clients can
    * provide one or more filter parameters to get datatypes with a specific ID, of a specific type, or with a
    * specific version. Future versions of TAXII will add more advanced filtering capabilities.
    *
    * To support requesting a large number of datatypes, the Endpoint supports pagination as defined in section 3.4.
    * Clients can optionally provide their desired number of items per page and which page they want and servers
    * will return that result set. Servers can also override client-provided pagination parameters, including
    * requiring pagination when it isn't requested. As such, all clients should be aware that responses to this
    * Endpoint may be paginated and be prepared to properly handle that.
    *
    * When requesting STIX 2.0 content, the content will always be delivered in a STIX bundle (even if there's only
    * zero or one datatypes, in which case the bundle will be empty or only contain one object). Other content types
    * can be requested by using a different Accept header, however the specific representation of other content
    * types is not defined.
    *
    * Supported Method      GET
    * URL                   /<api-root>/collections/<id>/objects/
    *
    * Parameters            <api-root> - the base URL of the API Root containing the Collection
    *                       <id> -  the identifier of the Collection from which objects are being requested
    *
    * Pagination            Yes
    * Filtering             Yes - id, type, version
    * Valid Request Type    Accept: application/vnd.oasis.taxii+json; version=2.0
    *
    * Successful Response   Status: 200 (OK)
    *                       Content-Type: application/vnd.oasis.taxii+json; version=2.0
    *                       Body: bundle
    *                       Requests for other content types are permitted and may result in other response bodies.
    *
    * Common Error Codes    404 - The Objects resource does not exist or the client does not have access to the
    *                       Objects resource.
    *                       401, 403 - The client either needs to authenticate or does not have access to get
    *                       Collection information.
    *
    * All HTTP 200 and 206 responses to the following Endpoints MUST include the X-TAXII-Date-Added-First header and
    * X-TAXII-Date-Added-Last header:
    *   GET <api-root>/collections/objects/
    *   GET <api-root>/collections/manifest/
    *
    * */
    Bundle getObjects(String apiRoot, UUID collectionId, String rangeHeader, ZonedDateTime addedAfter,
                      Set<Identifier> filterIds, Set<String> filterTypes, String filterVersion);

    /*
     * This Endpoint adds datatypes to a Collection.
     *
     * Successful responses to this Endpoint will contain a status resource describing the status of the request.
     * The status resource contains an id, which can be used to make requests to the get status Endpoint (see
     * section 4.3), a status flag to indicate whether the request is completed or still being processed, and
     * information about the status of the particular datatypes in the request.
     *
     * If the request is marked pending in the status field, the client SHOULD periodically poll the get status
     * Endpoint to get an updated status until such a time that the status property returns a value of complete. At
     * that point, the request can be considered complete.
     *
     * When adding STIX 2.0 content, clients MUST deliver all datatypes in a STIX bundle. Other content types MAY be
     * added (if the Collection supports it) by using a different Content-Type header, however the specific
     * representation of other content types is not defined.
     *
     * Supported Method      POST
     * URL                   /<api-root>/collections/<id>/objects/
     *
     * Parameters            <api-root> - the base URL of the API Root containing the Collection
     *                       <id> -  the identifier of the Collection from which objects are being requested
     *
     * Pagination            No
     * Filtering             No
     * Valid Request Type    Accept: application/vnd.oasis.taxii+json; version=2.0
     *                       Content-Type: application/vnd.oasis.stix+json; version=2.0
     *                       Body: bundle
     *                       POSTs containing other Content-Types are permitted and may have a different body.
     *
     * Successful Response   Status: 202 (Accepted)
     *                       Content-Type: application/vnd.oasis.taxii+json; version=2.0
     *                       Body: status
     *
     * Common Error Codes    422 - The object type or version is not supported or could not be processed. This can
     *                       happen, for example, when sending a version of STIX that this TAXII Server does not
     *                       support and cannot process, when sending a malformed body, or other unprocessable content.
     *                       401, 403 - The client either needs to authenticate or does not have access to get
     *                       Collection information.
     *
     * */
    StatusResource addObjects(String apiRoot, UUID collectionId, Bundle bundle);

    /*
     * This Endpoint gets an object from a Collection by its id. It can be thought of as a search where the match[id]
     * parameter is set to the <object-id> in the path. For STIX 2.0 datatypes, the <object-id> MUST be the STIX id.
     *
     * To support getting a particular version of an object, this Endpoint supports filtering as defined in section 3.5.
     * The only valid match parameter is version.
     *
     * When requesting STIX 2.0 content, the content will always be delivered in a STIX bundle (even if there's only
     * zero or one datatypes, in which case the bundle will be empty or only contain one object). Other content types
     * MAY be requested by using a different Accept header, however the specific representation of other content
     * types is not defined.
     *
     * Supported Method      GET
     * URL                   /<api-root>/collections/<id>/objects/<object-id>/
     *
     * Parameters            <api-root> - the base URL of the API Root containing the Collection
     *                       <id> -  the identifier of the Collection being requested
     *                       <object-id> - the ID of the object being requested
     *
     * Pagination            No
     * Filtering             Yes - version
     * Valid Request Type    Accept: application/vnd.oasis.taxii+json; version=2.0
     *
     * Successful Response   Status: 200 (OK)
     *                       Content-Type: application/vnd.oasis.taxii+json; version=2.0
     *                       Body: bundle
     *                       Requests for other content types are permitted and may result in other response bodies.
     *
     * Common Error Codes    404 - The object could not be found or the requester does not have access to get the
     *                       object.
     *                       401, 403 - The client either needs to authenticate or does not have access to get
     *                       Collection information.
     *
     * */
    Bundle getObject(String apiRoot, UUID collectionId, Identifier objectId, String version);

    /*
    * This Endpoint retrieves a manifest about datatypes from a Collection. It supports filtering and pagination
    * identical to the get datatypes Endpoint (see section 5.3) but rather than returning the object itself it returns
    * metadata about the object. It can be used to retrieve metadata to decide whether it's worth retrieving the
    * actual datatypes.
    *
    * This Endpoint supports filtering, which is applied against the source object rather than the manifest entry for
    * an object. Thus, searching the manifest for a type of indicator will return the manifest entries for datatypes
    * with a type of indicator, even though the manifest doesn't have a type field.
    *
    * Supported Method      GET
    * URL                   /<api-root>/collections/<id>/manifest/
    *
    * Parameters            <api-root> - the base URL of the API Root containing the Collection
    *                       <id> -  the identifier of the Collection being requested
    *
    * Pagination            Yes
    *
    * Filtering             Yes - id, type, version
    *                       Filtering is based on properties of the objects that the manifest entries represent. For
    *                       example, filtering by type=indicator will return manifest entries for objects with a
    *                       type of indicator
    *
    * Valid Request Type    Accept: application/vnd.oasis.taxii+json; version=2.0
    *
    * Successful Response   Status: 200 (OK)
    *                       Content-Type: application/vnd.oasis.taxii+json; version=2.0
    *                       Body: manifest
    *
    * Common Error Codes    404 - The Manifest resource does not exist or the client does not have access to the
    *                       Manifest resource.
    *                       401, 403 - The client either needs to authenticate or does not have access to get
    *                       Collection information.
    *
    * All HTTP 200 and 206 responses to the following Endpoints MUST include the X-TAXII-Date-Added-First header and
    * X-TAXII-Date-Added-Last header:
    *   GET <api-root>/collections/objects/
    *   GET <api-root>/collections/manifest/
    * */
    ManifestResource getManifest(String apiRoot, UUID collectionId, Set<Identifier> filterId,
                                 Set<String> filterTypes, String filterVersion);

    default void setCustomerHeaders(ZonedDateTime addedFirst, HttpHeaders headers, ZonedDateTime addedLast) {

        headers.add(CustomHeaders.X_TAXII_DATE_ADDED_FIRST, addedFirst.withZoneSameInstant(UTC).toString());
        headers.add(CustomHeaders.X_TAXII_DATE_ADDED_LAST, addedLast.withZoneSameInstant(UTC).toString());
    }


}
