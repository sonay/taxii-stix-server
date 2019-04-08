package com.example.stix.api.datatypes;

import com.example.stix.api.StixType;

import java.util.UUID;

/*
* Type Name: identifier
*
* An identifier universally and uniquely identifies a SDO, SRO, Bundle, or Marking Definition. Identifiers MUST follow
* the form object-type--UUIDv4, where object-type is the exact value (all type names are lowercase strings, by
* definition) from the type property of the object being identified or referenced and where the UUIDv4 is an RFC
* 4122-compliant Version 4 UUID. The UUID MUST be generated according to the algorithm(s) defined in RFC 4122,
* section 4.4 (Version 4 UUID) [RFC4122].
*
* The JSON MTI serialization uses the JSON string type [RFC7159] when representing identifier.
* */
public interface Identifier {

    StixType getType();

    UUID getId();

}
