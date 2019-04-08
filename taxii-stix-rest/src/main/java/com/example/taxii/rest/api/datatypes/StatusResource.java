package com.example.taxii.rest.api.datatypes;

import java.time.ZonedDateTime;
import java.util.List;

/*
* Resource Name: status
*
* The status resource represents information about a request to add datatypes to a Collection. It contains information
* about the status of the request, such as whether or not it's completed (status) and the status of individual
* datatypes within the request (i.e. whether they are still pending, completed and failed, or completed and succeeded).
*
* The status resource is returned in two places: as a response to the initial request (see section 5.4) and in
* response to a get status request (see section 4.3), which can be made after the initial request to continuously
* monitor its status.
*
* The list of datatypes that are still pending and the list of datatypes that have been added are both lists of strings
* containing the identifier of the object (e.g., for STIX datatypes, their id). The list of datatypes that failed to be added is a simple type so that both the id and a message indicating why it failed can be provided.
*
* */
public interface StatusResource {

    enum Status {
        pending, complete
    }

    /*
    * The identifier of this Status resource.
    *
    * REQUIRED
    * */
    String getId();

    /*
    * The overall status of a previous POST request where an HTTP 202 (Accept) was returned. The value of this
    * property MUST be one of complete or pending. A value of complete indicates that this resource will not be
    * updated further and MAY be removed in the future. A status of pending indicates that this resource MAY update
    * in the future.
    * */
    Status status();

    /*
     * The total number of datatypes that were in the request. For a STIX bundle this would be the number of datatypes in
     * the bundle.
     *
     * REQUIRED
     * */
    int getTotalCount();

    /*
    * The number of datatypes that were successfully created.
    *
    * REQUIRED
    * */
    int getSuccessCount();

    /*
    * The number of datatypes that failed to be created.
    *
    * REQUIRED
    * */
    int getFailureCount();

    /*
    * The number of datatypes that have yet to be processed.
    *
    * REQUIRED
    * */
    int getPendingCount();

    /*
    * A list of object IDs that were successfully processed. For STIX datatypes the STIX ID MUST be used here. For
    * object types that do not have their own identifier, the server MAY use any value as the id.
    *
    * OPTIONAL
    * */
    List<String> getSuccesses();

    /*
    * A list of datatypes that were not successfully processed.
    *
    * OPTIONAL
    * */
    List<String> getFailures();

    /*
    * A list of datatypes for datatypes that have yet to be processed. For STIX datatypes the STIX ID MUST be used here.
    * For object types that do not have their own identifier, the server MAY use any value as the id.
    *
    * OPTIONAL
    * */
    List<String> getPendings();

    /*
    * The datetime of the request that this status resource is monitoring.
    *
    * OPTIONAL
    * */
    ZonedDateTime getTimestamp();

}
