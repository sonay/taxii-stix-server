package com.example.stix.validation.objects;

import com.example.stix.api.objects.Campaign;
import com.example.stix.validation.ValidationStrategy;

import static com.example.stix.api.objects.Campaign.*;
import static com.example.stix.validation.ValidationHelper.basicOptionalCheck;
import static com.example.stix.validation.ValidationHelper.basicRequiredCheck;


public class CampaignValidator extends CommonPropertiesValidator {

    public void validate(Campaign campaign, ValidationStrategy strategy) {
        super.validate(campaign, strategy);
        basicRequiredCheck(NAME_PROPERTY, campaign.getName(), strategy);
        basicOptionalCheck(DESCRIPTION_PROPERTY, campaign.getDescription(), strategy);
        basicOptionalCheck(ALIASES_PROPERTY, campaign.getAliases(), strategy);
        basicOptionalCheck(OBJECTIVE_PROPERTY, campaign.getObjective(), strategy);
        // NOTE: because they are optional, first_seen and last_seen do not need to be checked,
        // TODO: Though should we check if last_seen is not before first_seen???
    }

}
