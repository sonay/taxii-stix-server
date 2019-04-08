package com.example.stix.validation.objects;

import com.example.stix.api.objects.Identity;
import com.example.stix.api.vocabularies.IdentityClassVocabulary;
import com.example.stix.api.vocabularies.IndustrySectorVocabulary;
import com.example.stix.validation.ValidationMessages;
import com.example.stix.validation.ValidationStrategy;

import java.util.List;

import static com.example.stix.api.objects.Identity.*;
import static com.example.stix.validation.ValidationHelper.basicOptionalCheck;
import static com.example.stix.validation.ValidationHelper.basicRequiredCheck;

public class IdentityValidator extends CommonPropertiesValidator {

    public void validate(Identity identity, ValidationStrategy strategy) {
        super.validate(identity, strategy);
        basicRequiredCheck(NAME_PROPERTY, identity.getName(), strategy);

        String clazz = identity.getIdentityClass();
        if ((clazz != null) && basicRequiredCheck(IDENTITY_CLASS_PROPERTY, clazz, strategy)) {
            if (!IdentityClassVocabulary.isStandard(clazz)) {
                strategy.onPropertyWarning(IDENTITY_CLASS_PROPERTY,
                        ValidationMessages.IDENTITY_VOCABULARY_WARNING);
            }
        }

        List<String> sectors = identity.getSectors();
        if ((sectors != null) && basicOptionalCheck(SECTORS_PROPERTY, sectors, strategy)) {
            for (String s : sectors) {
                if (!IndustrySectorVocabulary.isStandard(s)) {
                    strategy.onPropertyWarning(SECTORS_PROPERTY,
                            ValidationMessages.SECTORS_VOCABULARY_WARNING);
                    break;
                }
            }
        }
        basicOptionalCheck(DESCRIPTION_PROPERTY, identity.getDescription(), strategy);
        basicOptionalCheck(CONTACT_INFORMATION_PROPERTY, identity.getContactInformation(), strategy);
    }

}
