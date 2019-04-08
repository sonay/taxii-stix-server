package com.example.stix.validation.relationships;

import com.example.stix.api.StixType;
import com.example.stix.api.datatypes.Identifier;
import com.example.stix.api.relationships.Relationship;
import com.example.stix.api.relationships.RelationshipTypes;
import com.example.stix.validation.ValidationMessages;
import com.example.stix.validation.ValidationStrategy;
import com.example.stix.validation.objects.CommonPropertiesValidator;

import java.util.regex.Pattern;

import static com.example.stix.api.relationships.Relationship.*;
import static com.example.stix.validation.ValidationHelper.basicOptionalCheck;
import static com.example.stix.validation.ValidationHelper.basicRequiredCheck;

public class RelationshipValidator extends CommonPropertiesValidator {

    // TODO: test the pattern
    private static final Pattern RELATIONSHIP_TYPE_PATTERN = Pattern.compile("^([a-z]|[0-9]|-)+$");


    public void validate(Relationship relationship, ValidationStrategy strategy) {
        super.validate(relationship, strategy);
        Identifier sourceRef = relationship.getSourceRef();
        if (basicRequiredCheck(SOURCE_REF_PROPERTY, sourceRef, strategy)) {
            StixType type = sourceRef.getType();
            if (!type.isSDO()) {
                strategy.onPropertyError(SOURCE_REF_PROPERTY, ValidationMessages.NOT_AN_SDO_ERROR);
            }
        }

        Identifier targetRef = relationship.getTargetRef();
        if (basicRequiredCheck(TARGET_REF_PROPERTY, targetRef, strategy)) {
            StixType type = targetRef.getType();
            if (!type.isSDO()) {
                strategy.onPropertyError(TARGET_REF_PROPERTY, ValidationMessages.NOT_AN_SDO_ERROR);
            }
        }

        String relationshipType = relationship.getRelationshipType();
        if (basicRequiredCheck(RELATIONSHIP_TYPE_PROPERTY, relationshipType, strategy)) {
            if (!RelationshipTypes.isStandard(relationshipType)) {
                strategy.onPropertyWarning(RELATIONSHIP_TYPE_PROPERTY,
                        ValidationMessages.NOT_A_STANDARD_RELATIONSHIP_WARNING);
                if (!RELATIONSHIP_TYPE_PATTERN.matcher(relationshipType).matches()) {
                    strategy.onPropertyError(RELATIONSHIP_TYPE_PROPERTY,
                            ValidationMessages.INVALID_RELATIONSHIP_TYPE_DEFINITION_ERROR);
                }
            }
        }

        basicOptionalCheck(DESCRIPTION_PROPERTY, relationship.getDescription(), strategy);
    }

}
