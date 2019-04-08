package com.example.taxii.rest.api;

public interface CustomHeaders {

    /*
    * The X-TAXII-Date-Added-First header is an extension header. It indicates the date_added timestamp of the first
    * object of the response.
    *
    * The value of this header MUST be a timestamp. All HTTP 200 and 206 responses to the following Endpoints MUST
    * include the X-TAXII-Date-Added-First header:
    *   GET <api-root>/collections/objects/
    *   GET <api-root>/collections/manifest/
    * */
    // TODO: path should have been <api-root>/collections/<collection-id>/objects/ in the spec? Typo?
    String X_TAXII_DATE_ADDED_FIRST = "X-TAXII-Date-Added-First";


    /*
    * The X-TAXII-Date-Added-Last header is an extension header. It indicates the date_added timestamp of the last
    * object of the response.
    *
    * The value of this header MUST be a timestamp. All HTTP 200 and 206 responses to the following Endpoints MUST
    * include the X-TAXII-Date-Added-Last header:
    *   GET <api-root>/collections/objects/
    *   GET <api-root>/collections/manifest/
    * */
    String X_TAXII_DATE_ADDED_LAST = "X-TAXII-Date-Added-Last";
}
