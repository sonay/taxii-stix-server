package com.example.stix.api.datamarking;

import com.example.stix.api.BundleObject;
import com.example.stix.api.StixType;
import com.example.stix.api.datatypes.ExternalReference;
import com.example.stix.api.datatypes.Identifier;

import java.time.ZonedDateTime;
import java.util.List;

/*
* Type Name: marking-definition
* The marking-definition object represents a specific marking. Data markings typically represent handling or sharing
* requirements for data, and are applied in the object_marking_refs and granular_markings properties on STIX
* Objects, which reference a list of IDs for marking-definition datatypes.
*
* Two marking definition types are defined in this specification: TLP, to capture TLP markings, and Statement, to
* capture text marking statements. In addition, it is expected that the FIRST Information Exchange Policy (IEP) will
* be included in a future version once a machine-usable specification for it has been defined.
*
* Unlike STIX Objects, Marking Definition datatypes cannot be versioned because it would allow for indirect changes to
* the markings on a STIX Object. For example, if a Statement marking is changed from "Reuse Allowed" to "Reuse
* Prohibited", all STIX Objects marked with that Statement marking would effectively have an updated marking without
* being updated themselves. Instead, a new Statement marking with the new text should be created and the marked
* datatypes updated to point to the new marking.
*
* The JSON MTI serialization uses the JSON object type [RFC7159] when representing marking-definition.
*
* NOTE: Data Marking is not a STIX Object and MUST NOT have any SRO relationships to it or from it. This table lists
* the embedded relationships by property name along with their corresponding target.
* */
public interface MarkingDefinition extends BundleObject {

    /*
    * The type property identifies the type of object. The value of this property MUST be marking-definition.
    *
    * REQUIRED
    * */
    String TYPE_PROPERTY = "type";

    String TYPE = "marking-definition";

    default StixType getType() {
        return StixType.MARKING_DEFINITION;
    }


    /*
    * The id property universally and uniquely identifies this Marking Definition.
    *
    * Because the object type is part of the identifier, it is not possible for datatypes of different types to share the same id.
    *
    * REQUIRED
    * */
    String ID_PROPERTY = "id";

    Identifier getId();


    /*
     * The definition_type property identifies the type of Marking Definition. The value of the definition_type
     * property SHOULD be one of the types defined in the subsections below: statement or tlp (see sections 4.1.3 and
     * 4.1.4)
     *
     * REQUIRED
     * */
    String DEFINITION_TYPE_PROPERTY = "definition_type";

    String getDefinitionType();
    // TODO: fix this if OpenVocabulary becomes a type.
    //OpenVocabulary getDefinitionType();


    /*
     * The definition property contains the marking object itself (e.g., the TLP marking as defined in section 4.1.4,
     * the Statement marking as defined in section 4.1.3, or some other marking definition defined elsewhere).
     *
     * REQUIRED
     * */
    String DEFINITION_PROPERTY = "definition";

    MarkingObject getDefinition();


    /*
     * The created property represents the time at which the Marking Definition was created. The object creator can
     * use the time it deems most appropriate as the time the object was created.
     *
     * REQUIRED
     * */
    String CREATED_PROPERTY = "created";

    ZonedDateTime getCreated();


    /*
    * The created_by_ref property specifies the ID of the identity object that describes the entity that created
    * this Marking Definition.
    *
    * If this attribute is omitted, the source of this information is undefined. This may be used by object creators
    * who wish to remain anonymous.
    *
    * OPTIONAL
    * */
    String CREATED_BY_REF_PROPERTY = "created_by_ref";

    Identifier getCreatedByRef();


    /*
    * The external_references property specifies a list of external references which refers to non-STIX information.
    * This property is used to provide one or more URLs, descriptions, or IDs to records in other systems.
    *
    * OPTIONAL
    * */
    String EXTERNAL_REFERENCES_PROPERTY = "external_references";

    List<ExternalReference> getExternalReferences();


    /*
    * The object_marking_refs property specifies a list of IDs of marking-definitions that apply to this Marking
    * Definition. This property MUST NOT contain any references to this Marking Definition object (i.e., it cannot
    * contain any circular references).
    *
    * Though uncommon, in some cases marking definitions themselves may be marked with sharing or handling guidance.
    *
    * OPTIONAL
    * */
    String OBJECT_MARKING_REFS_PROPERTY = "object_marking_refs";

    List<Identifier> getObjectMarkingRefs();


    /*
    * The granular_markings property specifies a list of granular markings applied to this. This property MUST NOT
    * contain any references to this Marking Definition object (i.e., it cannot contain any circular references).
    *
    * Though uncommon, in some cases Marking Definitions themselves may be marked with sharing or handling guidance.
    *
    * OPTIONAL
    * */
    String GRANULAR_MARKINGS_PROPERTY = "granular_markings";

    List<GranularMarking> getGranularMarkings();


}
