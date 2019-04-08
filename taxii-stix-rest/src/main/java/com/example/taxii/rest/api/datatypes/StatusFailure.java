package com.example.taxii.rest.api.datatypes;

/*
* Type Name: status-failure
*
* This type represents an object that was not added to the Collection. It contains the id of the object and a message
* describing why it couldn't be added.
* */
public interface StatusFailure {

    /*
    * The identifier of the object that failed to be created. For STIX datatypes the id MUST be the STIX Object id. For
    * object types that do not have their own identifier, the server MAY use any value as the id.
    *
    * REQUIRED
    * */
    String getId();

    /*
    * A message indicating why the object failed to be created.
    *
    * OPTIONAL
    * */
    String getMessage();

}
