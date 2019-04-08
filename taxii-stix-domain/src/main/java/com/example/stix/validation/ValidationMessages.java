package com.example.stix.validation;

// TODO: move those to a message.properties file maybe?

public interface ValidationMessages {

    // ERRORS

    String EMPTY_VALUE_ERROR = "Empty values are prohibited in STIX.";

    String EMPTY_LIST_ERROR = "Empty lists are prohibited in STIX.";

    String MODIFIED_BEFORE_CREATED_ERROR = "The value of the modified property for a given object version MUST be later than or equal to the value of the created property.";

    String REQUIRED_ERROR = "Missing required property.";

    String ID_MISMATCH_ERROR = "Has different type from the type property of the object being identified or referenced.";

    String CREATED_BY_NOT_IDENTITY_ERROR = "Created by ref MUST reference an Identity object";

    String EXTERNAL_REFERENCE_MISSING_VALUE_ERROR = "At least one of the description, url, or external_id properties MUST be present.";

    String NOT_AN_SDO_ERROR = "The value MUST be an ID reference to an SDO (i.e., it cannot point to an SRO, Bundle, or Marking Definition).";

    String INVALID_RELATIONSHIP_TYPE_DEFINITION_ERROR = "Value of this property MUST be in ASCII and is " +
            "limited to characters a–z (lowercase ASCII), 0–9, and hyphen (-).";

    String BUNDLE_SPEC_VERSION_ERROR = "The value of this property MUST be 2.0";

    String INVALID_NUMBER_OBSERVED_ERROR = "MUST be an integer between 1 and 999,999,999 inclusive.";


    // WARNINGS

    String KILL_CHAIN_NAME_WARNING = "SHOULD be all lowercase and SHOULD use hyphens instead of spaces or underscores as word " +
            "separators characters.";

    String KILL_CHAIN_PHASE_NAME_WARNING = KILL_CHAIN_NAME_WARNING;

    String IDENTITY_VOCABULARY_WARNING = "Values SHOULD come from the identity-class-ov vocabulary.";

    String SECTORS_VOCABULARY_WARNING = "Values SHOULD come from the industry-sector-ov vocabulary.";

    String INDICATOR_LABEL_VOCABULARY_WARNING = "Values SHOULD come from the indicator-label-ov vocabulary.";

    String ATTACK_MOTIVATION_VOCABULARY_WARNING = "Values SHOULD come from the attack-motivation-ov vocabulary.";

    String ATTACK_RESOURCE_LEVEL_VOCABULARY_WARNING = "Values SHOULD come from the attack-motivation-ov vocabulary.";

    String MALWARE_LABEL_VOCABULARY_WARNING = "Values SHOULD come from the malware-label-ov vocabulary.";

    String NOT_A_STANDARD_RELATIONSHIP_WARNING = "Value SHOULD be an exact value listed in the relationships for the " +
            "source and target SDO.";

    String REPORT_LABEL_VOCABULARY_WARNING = "Values SHOULD come from the report-label-ov vocabulary.";

    String THREAT_ACTOR_ROLE_VOCABULARY_WARNING = "Values SHOULD come from the threat-actor-role-ov vocabulary.";

    String THREAT_ACTOR_SOPHISTICATION_VOCABULARY_WARNING = "Values SHOULD come from the " +
            "threat-actor-sophistication-ov vocabulary.";

    String THREAT_ACTOR_LABEL_VOCABULARY_WARNING = "Values SHOULD come from the threat-actor-label-ov vocabulary.";

    String TOOL_LABEL_VOCABULARY_WARNING = "Values SHOULD come from the tool-label-ov vocabulary.";
}
