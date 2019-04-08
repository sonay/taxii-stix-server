package com.example.taxii.rest.api.datatypes;

import java.util.SortedSet;

/*
* Resource Name: collections
*
* The collections resource is a simple wrapper around a list of collection resources.
* */
public interface CollectionsResource {

    /*
    * A list of Collections. If there are no Collections in the list, this key MUST be omitted and the response is
    * an empty object. The collection resource is defined in section 5.2.1.
    *
    * For the Collections Endpoint, Collections MUST be sorted and MAY be sorted in any order. Pagination requires a
    * consistent sort order, and therefore multiple responses from the same endpoint need to be sorted in a
    * consistent manner. Sort order MUST be consistent across responses.
    *
    * OPTIONAL
    * */
    SortedSet<CollectionResource> getCollections();

}
