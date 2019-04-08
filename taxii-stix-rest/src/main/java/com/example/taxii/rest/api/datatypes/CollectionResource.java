package com.example.taxii.rest.api.datatypes;

import java.util.List;
import java.util.UUID;

/*
* A TAXII Collection is an interface to a logical repository of CTI datatypes provided by a TAXII Server and is used
* by TAXII Clients to send information to the TAXII Server or request information from the TAXII Server. A TAXII
* Server can host multiple Collections per API Root, and Collections are used to exchange information in a
* request–response manner.
*
* Resource Name: collection
*
* The collection resource contains general information about a Collection, such as its id, a human-readable title and
* description, an optional list of supported media_types (representing the media type of datatypes can be requested
* from or added to it), and whether the TAXII Client, as authenticated, can get datatypes from the Collection and/or
* add datatypes to it.
* */
public interface CollectionResource {

    /*
    * The id property universally and uniquely identifies this Collection. It is used in the Get Collection Endpoint
    * (see section 5.2) as the <id> parameter to retrieve the Collection.
    * */
    UUID getIdentifier();

    /*
    * A human readable plain text title used to identify this Collection.
    *
    * REQUIRED
    * */
    String getTitle();

    /*
    * Indicates if the requester can read (i.e., GET) datatypes from this Collection.
    *
    * REQUIRED
    * */
    boolean canRead();

    /*
    * Indicates if the the requester can write (i.e., POST) datatypes to this Collection.
    *
    * REQUIRED
    * */
    boolean canWrite();

    /*
    * A human readable plain text description for this Collection.
    *
    * OPTIONAL
    * */
    String getDescription();

    /*
    * A list of supported media types for Objects in this Collection. Absence of this field is equivalent to a
    * single-value list containing  application/vnd.oasis.stix+json.
    *
    * OPTIONAL
    * */
    List<String> getMediaTypes();
}
