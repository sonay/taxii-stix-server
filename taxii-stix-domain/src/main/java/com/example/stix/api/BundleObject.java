package com.example.stix.api;

/*
* Common type for elements of StixBundle's datatypes properties.
*
* Objects of this type MUST be a STIX Object (SDO, SRO or Custom Object) or a Marking Definition object.
*
* This interface is a common subset of their REQUIRED properties.
*
* */
public interface BundleObject {

    // OUT OF SPEC, implementation method, intended for validation
    void accept(BundleObjectVisitor visitor);

}
