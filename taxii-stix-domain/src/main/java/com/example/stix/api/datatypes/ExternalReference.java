package com.example.stix.api.datatypes;

import com.example.stix.api.StixType;

import java.util.Map;

/*
* Type Name: external-reference
*
* External references are used to describe pointers to information represented outside of STIX. For example, a Malware
* object could use an external reference to indicate an ID for that malware in an external database or a report
* could use references to represent source material.

* The JSON MTI serialization uses the JSON object type [RFC7159] when representing external-reference.
*
* REQUIREMENTS
*
* In addition to the source_name property, at least one of the description, url, or external_id properties MUST be
* present.
*
* */
public interface ExternalReference {

    String TYPE = "external-reference";

    default StixType getType() {
        return StixType.EXTERNAL_REFERENCE;
    }

    /*
    * The source within which the external-reference is defined (system, registry, organization, etc.).
    *
    * REQUIRED
    * */
    String SOURCE_NAME_PROPERTY = "source_name";

    String getSourceName();


    /*
    * A human readable description.
    *
    * OPTIONAL
    * */
    String DESCRIPTION_PROPERTY = "description";

    String getDescription();


    /*
    * A URL reference to an external resource [RFC3986].
    *
    * OPTIONAL
    * */
    String URL_PROPERTY = "url";

    String getUrl();


    /*
    * Specifies a dictionary of hashes for the contents of the url. This SHOULD be provided when the url property is
    * present.
    *
    * OPTIONAL
    * */
    String HASHES_PROPERTY = "hashes";

    Map<String, String> getHashes();


    /*
    * An identifier for the external reference content.
    *
    * OPTIONAL
    * */
    String EXTERNAL_ID_PROPERTY = "external_id";

    String getExternalId();

}
