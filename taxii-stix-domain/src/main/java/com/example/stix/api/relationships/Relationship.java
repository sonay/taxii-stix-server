package com.example.stix.api.relationships;

import com.example.stix.api.StixType;
import com.example.stix.api.datatypes.Identifier;

/*
* Type Name: relationship
*
* The Relationship object is used to link together two SDOs in order to describe how they are related to each other.
* If SDOs are considered "nodes" or "vertices" in the graph, the Relationship Objects (SROs) represent "edges".
*
* STIX defines many relationship types to link together SDOs. These relationships are contained in the "Relationships"
* table under each SDO definition. Relationship types defined in the specification SHOULD be used to ensure
* consistency. An example of a specification-defined relationship is that an indicator indicates a campaign. That
* relationship type is listed in the Relationships section of the Indicator SDO definition.
*
* STIX also allows relationships from any SDO to any SDO that have not been defined in this specification. These
* relationships MAY use the related-to relationship type or MAY use a custom relationship type. As an example, a
* user might want to link malware directly to a tool. They can do so using related-to to say that the Malware is
* related to the Tool but not describe how, or they could use delivered-by (a custom name they determined) to
* indicate more detail.
*
* Note that some relationships in STIX may seem like "shortcuts". For example, an Indicator doesn't really detect a
* Campaign: it detects activity (Attack Patterns, Malware, etc.) that are often used by that campaign. While some
* analysts might want all of the source data and think that shortcuts are misleading, in many cases it's helpful to
* provide just the key points (shortcuts) and leave out the low-level details. In other cases, the low-level
* analysis may not be known or sharable, while the high-level analysis is. For these reasons, relationships that
* might appear to be "shortcuts" are not excluded from STIX.
* */
public interface Relationship extends StixRelationshipObject {

    /*
    * The value of this property MUST be "relationship".
    *
    * REQUIRED
    * */
    String TYPE = "relationship";

    default StixType getType() {
        return StixType.RELATIONSHIP;
    }


    /*
    *  The name used to identify the type of Relationship. This value SHOULD be an exact value listed in the
    *  relationships for the source and target SDO, but MAY be any string. The value of this property MUST be in
    *  ASCII and is limited to characters a–z (lowercase ASCII), 0–9, and hyphen (-).
    *
    *  REQUIRED
    * */
    String RELATIONSHIP_TYPE_PROPERTY = "relationship_type";

    String getRelationshipType();


    /*
     * The id of the source (from) object. The value MUST be an ID reference to an SDO (i.e., it cannot point to an
     * SRO, Bundle, or Marking Definition).
     *
     * REQUIRED
     * */
    String SOURCE_REF_PROPERTY = "source_ref";

    Identifier getSourceRef();

    /*
     * The id of the target (to) object. The value MUST be an ID reference to an SDO (i.e., it cannot point to an
     * SRO, Bundle, or Marking Definition).
     *
     * REQUIRED
     * */
    String TARGET_REF_PROPERTY = "target_ref";

    Identifier getTargetRef();


    /*
    *  A description that provides more details and context about the Relationship, potentially including its purpose
    *  and its key characteristics.
    *
    *  OPTIONAL
    * */
    String DESCRIPTION_PROPERTY = "description";

    String getDescription();

}
