package com.example.taxii.rest.api.datatypes;

import java.util.SortedSet;

/*
* Resource Name: manifest
*
* The manifest resource is a simple wrapper around a list of manifest-entry items.
* */
public interface ManifestResource {

    /*
    * The list of manifest entries for datatypes returned by the request. If there are no manifest-entry items in the
    * list, this key MUST be omitted and the response is an empty object.
    *
    * For the Collection and Manifest Endpoints, objects MUST be sorted in ascending order by the date the object
    * first appeared in the TAXII Collection (i.e., the added date). The most recently added object is last in the
    * list.
    * */
    SortedSet<ManifestEntry> getObjects();

}
