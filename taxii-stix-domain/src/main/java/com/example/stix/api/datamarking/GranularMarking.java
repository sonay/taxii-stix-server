package com.example.stix.api.datamarking;

import com.example.stix.api.datatypes.Identifier;

import java.util.List;

/*
* The granular-marking type defines how the marking-definition object referenced by the marking_ref property applies
* to a set of content identified by the list of selectors in the selectors property.
* */
public interface GranularMarking {

    /*
    * The marking_ref property specifies the ID of the marking-definition object that describes the marking.
    *
    * REQUIRED
    * */
    String MARKING_REF_PROPERTY = "marking_ref";

    Identifier getMarkingRef();


    /*
    * The selectors property specifies a list of selectors for content contained within the STIX Object in which
    * this property appears. Selectors MUST conform to the syntax defined in section 4.3.1.1.
    *
    * The marking-definition referenced in the marking_ref property is applied to the content selected by the
    * selectors in this list.
    *
    * REQUIRED
    * */
    String SELECTORS_PROPERTY = "selectors";

    List<String> getSelectors();


}
