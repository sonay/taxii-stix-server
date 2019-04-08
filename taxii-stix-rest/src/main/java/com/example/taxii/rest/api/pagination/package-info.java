package com.example.taxii.rest.api.pagination;

/*
 * Pagination is a feature that is used to break up result sets over multiple request/response pairs. TAXII uses
 * HTTP's Range and Content-Range headers, and defines the items range unit, to perform pagination as defined in
 * section 2 of [RFC7233]. items is the mandatory to implement range unit for TAXII. Other range units MAY be
 * implemented by clients and servers.
 *
 * The items range unit is defined for expressing subranges of a resource [HTTP 7233]. For the Endpoints that return
 * object, items represents objects. For the Endpoints that return collections, items represents Collections.
 *
 * The first items value in the Range and Content-Range headers gives the first item in a range. The last items value
 * in the Range and Content-Range headers gives the last item in the range; that is, items ranges specified are
 * inclusive. items are zero-indexed; that is, the first item is object zero. A Content-Range header will have a
 * third value that identifies the size of the available dataset.
 *
 * For example:
 *
 *   If the Range header contains "items 10-49", "10" represents the first item requested; and "49" represents the last
 *   item requested.
 *
 *   if the Content-Range header contains "items 10-49/500", "10" represents the first object in the response; "49"
 *   represents the last object in the response; and "500" represents the total number of items available.
 *
 * All items values MUST be:
 *   a non-negative integer
 *   zero indexed (i.e., the first object is object "0")
 *
 * REQUIREMENTS
 *
 * The following requirements only apply to items based range requests (aka pagination).
 *
 *   The Accept-Ranges header allows a server to indicate that it supports range requests for the target resource
 *   [RFC7233] as well as which range units are supported.
 *
 *   For resources where items-based pagination is supported, and where the Accept-Ranges header is present, the
 *   Accept-Ranges header MUST contain items as an acceptable range. The Accept-Ranges header MAY contain other
 *   acceptable ranges, if the server supports them.
 *
 *   Requests MAY use the Range header to request a subset of data that would otherwise be returned.
 *
 *   As defined in the HTTP specification, HTTP 206 (Partial Content) [RFC7233] responses include a Content-Range header,
 *   even if the entire resource is contained in the response.
 *
 *   As defined in the HTTP specification, if the requested Range cannot be satisfied, an HTTP 416 (Requested Range
 *   Not Satisfiable) [RFC7233] response is used.
 *       For example, if a range requests items 500-600, but only 0-100 are available, an HTTP 416 (Requested Range Not
 *       Satisfiable) is used.
 *
 *   An HTTP 206 (Partial Content) response with a Content-Range header MAY be returned even if the original request did
 *   not have a Range header.
 *       Note that this is a deviation from the HTTP specification, which indicates that HTTP 206 responses are only
 *       permitted when the Range header is present in the request.
 *
 *   Responses to requests with a Range header SHOULD contain only the requested range and MAY include a range smaller
 *   than what was requested.
 *
 *   TAXII follows standard HTTP rules for the Content-Range and Range headers, with the exception of allowing a 206
 *   response to a request without a Range header:
 *
 *       The 206 (Partial Content) status code indicates that the server is successfully fulfilling a range request for the
 *       target resource see section 4.1 of [RFC7233]
 *
 *       If a single part is being transferred, the server generating the 206 response MUST generate a Content-Range header
 *       field, describing what range of the selected representation is enclosed, and a payload consisting of the
 *       range. See section 4.2 of [RFC7233].
 *
 * NOTE: The total number of items available in a result may change with each request for a new page in the paginated
 * result set. This can happen if items have been added or deleted between subsequent requests.
 * */