package com.example.taxii.rest.api.datatypes;

import com.example.stix.api.datatypes.Identifier;

import java.time.ZonedDateTime;
import java.util.List;

/*
* Type Name: manifest-entry
*
* The manifest-entry type captures metadata about a single object, indicated by the id property. The metadata includes
* information such as when the object was added to the Collection, what versions of the object are available, and
* what media types the object is available in.
*
* */
public interface ManifestEntry {

    /*
    * The identifier of the object that this manifest entry describes.
    *
    * REQUIRED
    * */
    Identifier getId();

    /*
    * The date and time this object was added to the server.
    *
    * OPTIONAL
    * */
    ZonedDateTime getDateAdded();

    /*
    * A list of available versions, sorted in order from most recent version to least recent version.
    *
    * For example versions[0] contains the newest version and versions[len-1] contains the oldest version.
    *
    * For datatypes in STIX format, the STIX modified field is the version.
    *
    * OPTIONAL
    * */
    List<String> versions();

    /*
    * The media types that this object can be requested in.
    *
    * OPTIONAL
    * */
    List<String> getMediaTypes();

}
