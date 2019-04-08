package com.example.taxii.rest.api.datatypes;

import java.util.Map;

/*
* TAXII primarily relies on the standard HTTP error semantics (400-series and 500-series status codes, defined by
* sections 6.5 and 6.6 of [RFC7231]) to allow TAXII Servers to indicate when an error has occurred. For example, an
* HTTP 404 (Not Found) status code in response to a request to get information about a Collection means that the
* Collection could not be found. The tables defining the Endpoints in sections 4 and 5 identify common errors and
* which response should be used, but are not exhaustive and do not describe all possible errors.
*
* In addition to this, TAXII defines an error message structure that is provided in the response body when an error
* status is being returned. It does not, however, define any error codes or error conditions beyond those defined by HTTP.
*
* Message Name: error
*
* The error message is provided by TAXII Servers in the response body when returning an HTTP error status and contains
* more information describing the error, including a human-readable title and description, an error_code and
* error_id, and a details structure to capture further structured information about the error. All of the fields are
* application-specific and clients shouldn't assume consistent meaning across TAXII Servers even if the codes, IDs,
* or titles are the same.
*
* */
public interface ErrorMessage {

    /*
    * A human readable plain text title for this error.
    *
    * REQUIRED
    * */
    String getTitle();

    /*
    * A human readable plain text description that gives details about the error or problem that was encountered by
    * the application.
    *
    * OPTIONAL
    * */
    String getDescription();

    /*
    * An identifier for this particular error instance. A TAXII Server might choose to assign each error occurrence
    * it's own identifier in order to facilitate debugging.
    *
    * OPTIONAL
    * */
    String getErrorId();

    /*
    * The error code for this error type. A TAXII Server might choose to assign a common error code to all errors of
    * the same type. Error codes are application-specific and not intended to be meaningful across different TAXII
    * Servers.
    *
    * OPTIONAL
    * */
    String getErrorCode();

    /*
    * The HTTP status code applicable to this error.
    *
    * OPTIONAL
    * */
    String getHttpStatus();

    /*
    * A URL that points to additional details. For example, this could be a URL pointing to a knowledge base article
    * describing the error code. Absence of this field indicates that there are no additional details.
    *
    * OPTIONAL
    * */
    String getExternalDetails();

    /*
    * The details property captures additional server-specific details about the error. The keys and values are
    * determined by the TAXII Server and MAY be any valid JSON object structure.
    * */
    // TODO: find a more fitting return type.
    Map<String, String> details();


}
