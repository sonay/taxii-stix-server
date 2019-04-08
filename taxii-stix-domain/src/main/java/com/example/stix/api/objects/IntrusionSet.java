package com.example.stix.api.objects;

import com.example.stix.api.StixType;

import java.time.ZonedDateTime;
import java.util.List;

/*
* Type Name: intrusion-set
*
* An Intrusion Set is a grouped set of adversarial behaviors and resources with common properties that is believed to be
* orchestrated by a single organization. An Intrusion Set may capture multiple Campaigns or other activities that are
* all tied together by shared attributes indicating a common known or unknown Threat Actor. New activity can be
* attributed to an Intrusion Set even if the Threat Actors behind the attack are not known. Threat Actors can move from
* supporting one Intrusion Set to supporting another, or they may support multiple Intrusion Sets.
*
* Where a Campaign is a set of attacks over a period of time against a specific set of targets to achieve some
* objective, an Intrusion Set is the entire attack package and may be used over a very long period of time in multiple
* Campaigns to achieve potentially multiple purposes.
*
* While sometimes an Intrusion Set is not active, or changes focus, it is usually difficult to know if it has truly
* disappeared or ended. Analysts may have varying level of fidelity on attributing an Intrusion Set back to Threat
* Actors and may be able to only attribute it back to a nation state or perhaps back to an organization within that
* nation state.
* */
public interface IntrusionSet extends StixDomainObject {

    /*
    * The value of this property MUST be intrusion-set.
    * */
    String TYPE = "intrusion-set";

    @Override
    default StixType getType() {
        return StixType.INTRUSION_SET;
    }


    /*
    * A name used to identify this Intrusion Set.
    *
    * REQUIRED
    * */
    String NAME_PROPERTY = "name";

    String getName();


    /*
    * A description that provides more details and context about the Intrusion Set, potentially including its purpose
    * and its key characteristics.
    *
    * OPTIONAL
    * */
    String DESCRIPTION_PROPERTY = "description";

    String getDescription();


    /*
    * Alternative names used to identify this Intrusion Set
    *
    * OPTIONAL
    * */
    String ALIASES_PROPERTY = "aliases";

    List<String> getAliases();


    /*
    * The time that this Intrusion Set was first seen.
    *
    * This property is a summary property of data from sightings and other data that may or may not be available in
    * STIX. If new sightings are received that are earlier than the first seen timestamp, the object may be updated to
    * account for the new data.
    *
    * OPTIONAL
    * */
    String FIRST_SEEN_PROPERTY = "first_seen";

    ZonedDateTime getFirstSeen();


    /*
    * The time that this Intrusion Set was last seen.
    * This property is a summary property of data from sightings and other data that may or may not be available in
    * STIX. If new sightings are received that are later than the last seen timestamp, the object may be updated to
    * account for the new data.
    *
    * OPTIONAL
    */
    String LAST_SEEN_PROPERTY = "last_seen";

    ZonedDateTime getLastSeen();


    /*
    * The high level goals of this Intrusion Set, namely, what are they trying to do. For example, they may be motivated
    * by personal gain, but their goal is to steal credit card numbers. To do this, they may execute specific Campaigns
    * that have detailed objectives like compromising point of sale systems at a large retailer.
    *
    * Another example: to gain information about latest merger and IPO information from ACME Bank.
    *
    * OPTIONAL
    * */
    String GOALS_PROPERTY = "goals";

    List<String> getGoals();


    /*
    * This defines the organizational level at which this Intrusion Set typically works, which in turn determines the
    * resources available to this Intrusion Set for use in an attack.
    *
    * This is an open vocabulary and values SHOULD come from the attack-resource-level-ov vocabulary.
    *
    * OPTIONAL
    * */
    String RESOURCE_LEVEL_PROPERTY = "resource_level";

    String getResourceLevel();


    /*
    * The primary reason, motivation, or purpose behind this Intrusion Set. The motivation is why the Intrusion Set
    * wishes to achieve the goal (what they are trying to achieve).
    *
    * For example, an Intrusion Set with a goal to disrupt the finance sector in a country might be motivated by
    * ideological hatred of capitalism.
    *
    * This is an open vocabulary and values SHOULD come from the attack-motivation-ov vocabulary.
    *
    * OPTIONAL
    * */
    String PRIMARY_MOTIVATION_PROPERTY = "primary_motivation";

    String getPrimaryMotivation();


    /*
    * The secondary reasons, motivations, or purposes behind this Intrusion Set. These motivations can exist as an equal
    * or near-equal cause to the primary motivation. However, it does not replace or necessarily magnify the primary
    * motivation, but it might indicate additional context.
    *
    * This is an open vocabulary and values SHOULD come from the attack-motivation-ov vocabulary.
    *
    * OPTIONAL
    * */
    String SECONDARY_MOTIVATIONS_PROPERTY = "secondary_motivations";

    List<String> getSecondaryMotivations();

}
