package com.example.taxii.rest.api.datatypes;

import java.util.List;

/*
* Resource Name: api-root
*
* The api-root resource contains general information about the API Root, such as a human-readable title and
* description, the TAXII versions it supports, and the maximum size of the content body it will accept in a PUT or
* POST (max_content_length).
* */
public interface ApiRootResource {

    /*
    * A human readable plain text name used to identify this API instance.
    *
    * REQUIRED
    * */
    String TITLE_PROPERTY = "title";

    String getTitle();


    /*
     * The list of TAXII versions that this API Root is compatible with. A value of taxii-2.0 MUST be included in
     * this list to indicate conformance with this specification.
     *
     * REQUIRED
     * */
    String VERSIONS_PROPERTY = "versions";

    List<String> getVersions();


    /*
    * The maximum size of the request body in octets (8-bit bytes) that the server can support. This applies to
    * requests only and is determined by the server. Requests with total body length values smaller than this value
    * MUST NOT result in an HTTP 413 (Request Entity Too Large) response.
    *
    * REQUIRED
    * */
    String MAX_CONTENT_LENGTH_PROPERTY = "max_content_length";

    int getMaxContentLength();


    /*
    * A human readable plain text description for this API Root.
    *
    * OPTIONAL
    * */
    String DESCRIPTION_PROPERTY = "description";

    String getDescription();

}
