package com.example.stix.api;

import com.example.stix.api.datatypes.Identifier;

import java.util.List;

/*
* Type Name: bundle
*
* A Bundle is a collection of arbitrary STIX Objects and Marking Definitions grouped together in a single container. A
* Bundle does not have any semantic meaning and Objects are not considered related by virtue of being in the same Bundle.
*
* Bundle is not STIX Object, so it does not have any of the Common Properties other than the type and id properties.
* Bundle is transient and implementations should not assume that other implementations will treat it as a persistent
* object.
*
* The JSON MTI serialization uses the JSON object type [RFC7159] when representing bundle.
*
* NOTE: Bundle is not a STIX Object and MUST NOT have any relationships to it or from it.
* */
public interface Bundle {

    /*
    * The type property identifies the type of object. The value of this property MUST be bundle.
    *
    * REQUIRED
    * */
    String TYPE_PROPERTY = "type";

    String TYPE = "bundle";

    default StixType getType() {
        return StixType.BUNDLE;
    }


    /*
    * An identifier for this Bundle. The id property for the Bundle is designed to help tools that may need it for
    * processing, but tools are not required to store or track it. Consuming tools should not rely on the presence
    * of this property or the ability to refer to bundles by ID.
    *
    * REQUIRED
    * */
    String ID_PROPERTY = "id";

    Identifier getId();


    /*
    * The version of the STIX specification used to represent the content in this Bundle. This enables non-TAXII
    * transports or other transports without their own content identification mechanisms to know the version of STIX
    * content.
    *
    * The value of this property MUST be 2.0 for bundles containing STIX Objects defined in this specification.
    *
    * REQUIRED
    * */
    String SPEC_VERSION_PROPERTY = "spec_version";

    String SPEC_VERSION = "2.0";

    default String getSpecVersion() {
        return SPEC_VERSION;
    }

    /*
    * Specifies a set of one or more STIX Objects. Objects in this list MUST be a STIX Object (SDO, SRO or Custom
    * Object) or a Marking Definition object.
    *
    * OPTIONAL
    * */
    String OBJECTS_PROPERTY = "objects";

    List<BundleObject> getObjects();


}
