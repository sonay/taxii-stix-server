package com.example.stix.validation.objects;

import com.example.stix.api.CommonProperties;
import com.example.stix.api.objects.Report;
import com.example.stix.api.vocabularies.ReportLabelVocabulary;
import com.example.stix.validation.ValidationMessages;
import com.example.stix.validation.ValidationStrategy;

import java.util.List;

import static com.example.stix.api.objects.Report.*;
import static com.example.stix.validation.ValidationHelper.basicOptionalCheck;
import static com.example.stix.validation.ValidationHelper.basicRequiredCheck;

public class ReportValidator extends CommonPropertiesValidator {

    public void validate(Report report, ValidationStrategy strategy) {
        super.validate(report, strategy);
        basicRequiredCheck(NAME_PROPERTY, report.getName(), strategy);
        basicRequiredCheck(PUBLISHED_PROPERTY, report.getPublished(), strategy);
        // TODO: should we check for object types to validate they are in deed STIX Objects NOT SROs and what not???
        basicRequiredCheck(OBJECT_REFS_PROPERTY, report.getObjectRefs(), strategy);
        basicOptionalCheck(DESCRIPTION_PROPERTY, report.getDescription(), strategy);
    }

    @Override
    public void validateLabels(CommonProperties report, ValidationStrategy strategy) {
        List<String> labels  = report.getLabels();
        if (basicRequiredCheck(LABELS_PROPERTY, labels, strategy)) {
            for (String label : labels) {
                if (!ReportLabelVocabulary.isStandard(label)) {
                    strategy.onPropertyWarning(LABELS_PROPERTY,
                            ValidationMessages.REPORT_LABEL_VOCABULARY_WARNING);
                    break;
                }
            }
        }
    }

}
