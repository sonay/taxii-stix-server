package com.example.taxii.rest.api.datatypes;

import java.util.List;

/*
* Resource Name: discovery
*
* The discovery resource contains information about a TAXII Server, such as a human-readable title, description, and
* contact information, as well as a list of API Roots that it is advertising. It also has an indication of which API
* Root it considers the default, or the one to use in the absence of other information/user choice.
* */
public interface DiscoveryResource {

    /*
    * A human readable plain text name used to identify this server.
    *
    * REQUIRED
    * */
    String TITLE_PROPERTY = "title";

    String getTitle();


    /*
    * A human readable plain text description for this server.
    *
    * OPTIONAL
    * */
    String DESCRIPTION_PROPERTY = "description";

    String getDescription();


    /*
    * The human readable plain text contact information for this server and/or the administrator of this server.
    *
    * OPTIONAL
     * */
    String CONTACT_PROPERTY = "contact";

    String getContact();


    /*
    * The default API Root that a TAXII Client MAY use. Absence of this field indicates that there is no default API
    * Root. The default API Root MUST be an item in api_roots.
    *
    * OPTIONAL
    * */
    String DEFAULT_PROPERTY = "default";

    String getDefault();


    /*
    * A list of URLs that identify known API Roots. This list MAY be filtered on a per-client basis.
    *
    * OPTIONAL
    * */
    String API_ROOTS_PROPERTY = "api_roots";

    List<String> getApiRoots();
}
