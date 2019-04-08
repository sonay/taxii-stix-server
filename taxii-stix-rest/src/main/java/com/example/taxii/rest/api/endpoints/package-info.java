/*
 * An Endpoint consists of a specific URL and HTTP Method on a TAXII Server that a TAXII Client can contact to
 * engage in one, specific type of TAXII exchange. For example, each Collection on a TAXII Server has an Endpoint
 * that can be used to get information about it; TAXII Clients can contact the Collection’s Endpoint to request a
 * description of that Collection. A separate Endpoint is used for the TAXII Client to collect a manifest of that
 * Collection’s Content. Yet another Endpoint is used to get objects from the Collection and, at the same URL, a
 * POST can be used to add objects to the collection.
 *
 * The following normative requirements apply to each Endpoint:
 *
 *   All TAXII requests MUST include a media range in the Accept header. Requests for TAXII or STIX content MUST use the
 *   values from section 1.4.7 and SHOULD include the version parameter.
 *
 *   All TAXII responses MUST include the appropriate media type and version parameter in the Content-Type header as
 *   defined for that Endpoint.
 *
 *   TAXII responses SHOULD be the highest version of content (e.g., TAXII, STIX) that the server supports if the version
 *   parameter in the Accept header is omitted during content negotiation.
 *
 *   TAXII responses with an HTTP success code (200 series) that permit a response body MUST include the appropriate
 *   response body for the specified content type as identified in the definition of that Endpoint.
 *
 *   TAXII responses with an HTTP error code (400-series and 500-series status codes, defined by sections 6.5 and 6.6
 *   of [RFC7231]) that permit a response body (i.e. are not in response to a HEAD request) MUST contain an error
 *   message (see section 3.6.1) in the response body.
 *
 *   Requests with media types in the Accept and/or Content-Type headers that are defined for that Endpoint MUST NOT
 *   result in an HTTP 406 (Not Acceptable) or HTTP 415 (Unacceptable Media Type) response.
 *
 *   Requests with media types in the Accept and/or Content-Type headers that are not defined for that Endpoint MAY
 *   be satisfied with the appropriate content or MAY result in an HTTP 406 (Not Acceptable) or HTTP 415 (Unacceptable
 *   Media Type) response.
 *
 *   TAXII responses from Endpoints that support pagination and include items as a requested range unit MUST comply with
 *   the normative requirements in section 3.4 and MUST respond with an appropriate 200, 206, or 416 response per the
 *   HTTP specification [RFC7233].
 *
 *   TAXII responses to Endpoints that support filtering MUST filter results per the requirements in section 3.5.
 *
 *
 *   URL                                                 Methods     ResourceType
 *   Core Concepts (section 4)
 *   /taxii/                                             GET         discovery
 *   <api-root>                                          GET         api
 *   <api-root>/status/<status-id>/                      GET         status
 *
 *   Collections (section 5)
 *   <api-root>/collections/                             GET         collections
 *   <api-root>/collections/<id>/                        GET         collection
 *   <api-root>/collections/<id>/objects/                GET         object*
 *   <api-root>/collections/<id>/objects/<object-id>/    GET,POST    object*
 *   <api-root>/collections/<id>/manifest/               GET         manifest
 *
 *   Channels (section 6)
 *   <TBD in a future version>
 *
 *   * The actual format of objects is dependent on HTTP Content negotiation, as discussed in section 1.4.7
 * */
package com.example.taxii.rest.api.endpoints;