package com.example.stix.validation.objects;

import com.example.stix.api.CommonProperties;
import com.example.stix.api.datatypes.KillChainPhase;
import com.example.stix.api.objects.Tool;
import com.example.stix.api.vocabularies.ToolLabelVocabulary;
import com.example.stix.validation.ValidationMessages;
import com.example.stix.validation.ValidationStrategy;

import java.util.List;

import static com.example.stix.validation.ValidationHelper.basicOptionalCheck;
import static com.example.stix.validation.ValidationHelper.basicRequiredCheck;

public class ToolValidator extends CommonPropertiesValidator {

    public void validate(Tool tool, ValidationStrategy strategy) {
        super.validate(tool, strategy);
        basicRequiredCheck(Tool.NAME_PROPERTY, tool.getName(), strategy);
        basicOptionalCheck(Tool.DESCRIPTION_PROPERTY, tool.getDescription(), strategy);
        basicOptionalCheck(Tool.TOOL_VERSION_PROPERTY, tool.getToolVersion(), strategy);

        List<KillChainPhase> killChainPhases = tool.getKillChainPhases();
        if ((killChainPhases != null)
                && basicOptionalCheck(Tool.KILL_CHAIN_PHASES_PROPERTY, killChainPhases, strategy)) {
            for (KillChainPhase chainPhase : killChainPhases) {
                // TODO: implement
            }
        }
    }

    @Override
    public void validateLabels(CommonProperties tool, ValidationStrategy strategy) {
        List<String> labels = tool.getLabels();
        if ((labels != null) && basicRequiredCheck(Tool.LABELS_PROPERTY, labels, strategy)) {
            for (String label : labels) {
                if (!ToolLabelVocabulary.isStandard(label)) {
                    strategy.onPropertyWarning(Tool.LABELS_PROPERTY, ValidationMessages.TOOL_LABEL_VOCABULARY_WARNING);
                }
            }
        }
    }

}
