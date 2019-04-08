package com.example.stix.api;

import com.example.stix.api.datamarking.GranularMarking;
import com.example.stix.api.datatypes.ExternalReference;
import com.example.stix.api.datatypes.Identifier;

import java.time.ZonedDateTime;
import java.util.List;

/*
* Interface that represent common properties shared among SDOs and SROs.
*
* */
public interface CommonProperties {

    /*
     * The type property identifies the type of STIX Object. The value of the type property MUST be the name of one
     * of the types of STIX Object defined in sections 2 and 3 of STIX™ Version 2.0. Part 2: STIX Objects (e.g.,
     * indicator) or the name of a custom object as defined by section 7.2.
     *
     * REQUIRED
     * */
    String TYPE_PROPERTY = "type";

    StixType getType();


    /*
     * The id property universally and uniquely identifies this object. All datatypes with the same id are considered
     * different versions of the same object.
     *
     * Because the object type is part of the identifier, it is invalid for datatypes of different types to share the
     * same id.
     *
     * REQUIRED
     * */
    String ID_PROPERTY = "id";

    Identifier getId();


    /*
     * The created property represents the time at which the first version of this object was created. The object
     * creator can use the time it deems most appropriate as the time the object was created.
     *
     * The created property MUST NOT be changed when creating a new version of the object.
     *
     * The created timestamp MUST be precise to the nearest millisecond (exactly three digits after the decimal place in
     * seconds).
     *
     * See section 3.4 for further definition of versioning.
     *
     * REQUIRED
     * */
    String CREATED_PROPERTY = "created";

    ZonedDateTime getCreated();

    /*
     * The modified property represents the time that this particular version of the object was created. The object
     * creator can use the time it deems most appropriate as the time this version of the object was modified. The
     * value of the modified property for a given object version MUST be later than or equal to the value of the
     * created property.
     *
     * Object creators MUST set the modified property when creating a new version of an object.
     *
     * The modified timestamp MUST be precise to the nearest millisecond (exactly three digits after the decimal
     * place in seconds).
     *
     * See section 3.4 for further definition of versioning.
     *
     * REQIURED
     * */
    String MODIFIED_PROPERTY = "modified";

    ZonedDateTime getModified();


    /*
     * The created_by_ref property specifies the ID of the Identity object that describes the entity that created
     * this object.
     *
     * If this attribute is omitted, the source of this information is undefined. This may be used by object creators
     * who wish to remain anonymous.
     *
     * OPTIONAL
     * */
    String CREATED_BY_REF_PROPERTY = "created_by_ref";

    Identifier getCreatedByRef();


    /*
     * The revoked property indicates whether the object has been revoked. Revoked datatypes are no longer considered
     * valid by the object creator. Revoking an object is permanent; future versions of the object with this id MUST
     * NOT be created.
     *
     * The default value of this property is false.
     *
     * See section 3.4 for further definition of versioning.
     *
     * OPTIONAL
     * */
    String REVOKED_PROPERTY = "revoked";

    Boolean getRevoked();


    /*
     * The labels property specifies a set of classifications.
     *
     * Each STIX Object can define a suggested vocabulary for the labels property. For example, the Indicator object,
     * as defined in section 2.5 of STIX™ Version 2.0. Part 2: STIX Objects, uses the Indicator Label vocabulary as
     * defined in section 6.5.
     *
     * In some cases (generally, when a suggested vocabulary is defined) the labels property is then required for
     * that specific SDO.
     *
     * If a vocabulary is defined, items in this list SHOULD come from the vocabulary. Additional labels MAY be added
     * beyond what is in the suggested vocabulary.
     *
     * OPTIONAL
     * */
    String LABELS_PROPERTY = "labels";

    List<String> getLabels();


    /*
     *  The external_references property specifies a list of external references which refers to non-STIX information.
     *  This property is used to provide one or more URLs, descriptions, or IDs to records in other systems.
     *
     *  OPTIONAL
     * */
    String EXTERNAL_REFERENCES_PROPERTY = "external_references";

    List<ExternalReference> getExternalReferences();

    /*
     * The object_marking_refs property specifies a list of IDs of marking-definition datatypes that apply to this object.
     *
     * See section 4 for further definition of data markings.
     *
     * OPTIONAL
     * */
    String OBJECT_MARKING_REFS_PROPERTY = "object_marking_refs";


    List<Identifier> getObjectMarkingRefs();

    /*
     * The granular_markings property specifies a list of granular markings applied to this object.
     *
     * See section 4 for further definition of data markings.
     *
     * OPTIONAL
     * */
    String GRANULAR_MARKINGS_PROPERTY = "granular_markings";

    List<GranularMarking> getGranularMarkings();


}
