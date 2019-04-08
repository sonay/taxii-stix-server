package com.example.taxii.rest.api.endpoints;

import com.example.taxii.rest.api.datatypes.ApiRootResource;
import com.example.taxii.rest.api.datatypes.StatusResource;

import java.util.UUID;

/*
* This Endpoint provides general information about an API Root, which can be used to help users and clients decide
* whether and how they want to interact with it. Multiple API Roots MAY be hosted on a single TAXII Server. Often,
* an API Root represents a single trust group.
*
*   Each API Root MUST have a unique URL.
*   Each API Root MAY have different authentication and authorization schemes.
* */
public interface ApiRootEndpoint {

    /*
    * Supported Method      GET
    * URL                   /<api-root>
    * Parameters            <api-root> - the base URL of the API Root containing the Collections
    * Pagination            No
    * Filtering             No
    * Valid Request Type    Accept: application/vnd.oasis.taxii+json; version=2.0
    *
    * Successful Response   Status: 200 (OK)
    *                       Content-Type: application/vnd.oasis.taxii+json; version=2.0
    *                       Body: api-root
    *
    * Common Error Codes    404 - No API Root could be found or the requester does not have access to get API Root
    *                       information.
    *
    *                       401, 403 - The client either needs to authenticate or does not have access to get
    *                       Collection information.
    **/
    ApiRootResource getRoot(String apiRoot);

    /*
    * This Endpoint provides information about the status of a previous request. In TAXII 2.0, the only request that
    * can be monitored is one to add objects to a Collection (see section 5.4). It is typically used by TAXII
    * Clients to monitor a request that they made in order to take action when it is complete.
    *
    * TAXII Servers SHOULD provide status messages at this Endpoint while the request is in progress until at least 24
    * hours after it has been marked completed.
    *
    * Supported Method      GET
    * URL                   /<api-root>/status/<status-id>/
    * Parameters            <api-root> - the base URL of the API Root containing the Collections
    *                       <status-id> - the identifier of the status message being requested
    * Pagination            No
    * Filtering             No
    * Valid Request Type    Accept: application/vnd.oasis.taxii+json; version=2.0
    *
    * Successful Response   Status: 200 (OK)
    *                       Content-Type: application/vnd.oasis.taxii+json; version=2.0
    *                       Body: status
    *
    * Common Error Codes    404 - No status could be found or the requester does not have access to get status
    *                       information.
    *
    *                       401, 403 - The client either needs to authenticate or does not have access to get
    *                       Collection information.
    * */
    StatusResource getStatus(String apiRoot, UUID statusId);

}
