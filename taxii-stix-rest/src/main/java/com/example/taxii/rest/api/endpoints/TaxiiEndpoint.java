package com.example.taxii.rest.api.endpoints;

import com.example.taxii.rest.api.datatypes.DiscoveryResource;

/*
* This Endpoint provides general information about a TAXII Server, including the advertised API Roots. It's a common
* entry point for TAXII Clients into the data and services provided by a TAXII Server. For example, clients
* auto-discovering TAXII Servers via the DNS SRV record defined in section 1.4.1 will be able to automatically
* retrieve a discovery response for that server by requesting the /taxii/ path on that domain.
*
* Discovery API responses MAY advertise any TAXII API Root that they have permission to advertise, included those
* hosted on other servers.
* */
public interface TaxiiEndpoint {

    /*
    * This Endpoint provides general information about a TAXII Server, including the advertised API Roots. It's a
    * common entry point for TAXII Clients into the data and services provided by a TAXII Server. For example, clients auto-discovering TAXII Servers via the DNS SRV record defined in section 1.4.1 will be able to automatically retrieve a discovery response for that server by requesting the /taxii/ path on that domain.
    *
    * Discovery API responses MAY advertise any TAXII API Root that they have permission to advertise, included those
    * hosted on other servers.
    *
    * Supported Method      GET
    * URL                   /taxii/
    *
    * Parameters            N/A
    * Pagination            No
    * Filtering             No
    * Valid Request Type    Accept: application/vnd.oasis.taxii+json; version=2.0
    * Successful Response   Status: 200 (OK)
    *                       Content-Type: application/vnd.oasis.taxii+json; version=2.0
    *                       Body: discovery
    *
    * Common Error Codes    404 - No discovery information could be found or the requester does not have access to
    *                       get discovery information.
    *
    *                       401, 403 - The client either needs to authenticate or does not have access to get
    *                       Collection information.
    * */
    DiscoveryResource serverDiscovery();

}
