package com.example.stix.api.objects;

import com.example.stix.api.StixType;

import java.util.List;

/*
* Type Name: threat-actor
*
* Threat Actors are actual individuals, groups, or organizations believed to be operating with malicious intent.
* A Threat Actor is not an Intrusion Set but may support or be affiliated with various Intrusion Sets, groups, or
* organizations over time.
*
* Threat Actors leverage their resources, and possibly the resources of an Intrusion Set, to conduct attacks and run
* Campaigns against targets.
*
* Threat Actors can be characterized by their motives, capabilities, goals, sophistication level, past activities,
* resources they have access to, and their role in the organization.
* */
public interface ThreatActor extends StixDomainObject {


    /*
    * The value of this property MUST be"threat-actor".
    *
    * REQUIRED
    * */
    String TYPE = "threat-actor";

    @Override
    default StixType getType() {
        return StixType.THREAT_ACTOR;
    }


    /*
    * This property specifies the type of Threat Actor.
    *
    * This is an open vocabulary and values SHOULD come from the threat-actor-label-ov vocabulary.
    *
    * REQUIRED
    * */
    String LABELS_PROPERTY = "labels";

    @Override
    List<String> getLabels();


    /*
    * A name used to identify this Threat Actor or Threat Actor group.
    *
    * REQUIRED
    * */
    String NAME_PROPERTY = "name";

    String getName();


    /*
    * A description that provides more details and context about the Threat Actor, potentially including its purpose and
    * its key characteristics.
    *
    * OPTIONAL
    * */
    String DESCRIPTION_PROPERTY = "description";

    String getDescription();


    /*
    * A list of other names that this Threat Actor is believed to use.
    *
    * OPTIONAL
    * */
    String ALIASES_PROPERTY = "aliases";

    List<String> getAliases();


    /*
    * A list of roles the Threat Actor plays.
    *
    * This is an open vocabulary and the values SHOULD come from the threat-actor-role-ov vocabulary.
    *
    * OPTIONAL
    * */
    String ROLES_PROPERTY = "roles";

    List<String> getRoles();


    /*
    * The high level goals of this Threat Actor, namely, what are they trying to do. For example, they may be motivated
    * by personal gain, but their goal is to steal credit card numbers. To do this, they may execute specific
    * Campaigns that have detailed objectives like compromising point of sale systems at a large retailer.
    *
    * OPTIONAL
     * */
    String GOALS_PROPERTY = "goals";

    List<String> getGoals();


    /*
    * The skill, specific knowledge, special training, or expertise a Threat Actor must have to perform the attack.
    *
    * This is an open vocabulary and values SHOULD come from the threat-actor-sophistication-ov vocabulary.
    *
    * OPTIONAL
    * */
    String SOPHISTICATION_PROPERTY = "sophistication";

    String getSophistication();


    /*
    * This defines the organizational level at which this Threat Actor typically works, which in turn determines the
    * resources available to this Threat Actor for use in an attack. This attribute is linked to the sophistication
    * property — a specific resource level implies that the Threat Actor has access to at least a specific
    * sophistication level.
    *
    * This is an open vocabulary and values SHOULD come from the attack-resource-level-ov vocabulary.
    *
    * OPTIONAL
    * */
    String RESOURCE_LEVEL_PROPERTY = "resource_level";

    String getResourceLevel();


    /*
    * The primary reason, motivation, or purpose behind this Threat Actor. The motivation is why the Threat Actor
    * wishes to achieve the goal (what they are trying to achieve).
    *
    * For example, a Threat Actor with a goal to disrupt the finance sector in a country might be motivated by
    * ideological hatred of capitalism.
    *
    * This is an open vocabulary and values SHOULD come from the attack-motivation-ov vocabulary.
    *
    * OPTIONAL
    * */
    String PRIMARY_MOTIVATION_PROPERTY = "primary_motivation";

    String getPrimaryMotivation();


    /*
    * The secondary reasons, motivations, or purposes behind this Threat Actor.
    *
    * These motivations can exist as an equal or near-equal cause to the primary motivation. However, it does not
    * replace or necessarily magnify the primary motivation, but it might indicate additional context.
    *
    *This is an open vocabulary and values SHOULD come from the attack-motivation-ov vocabulary.
    *
    * OPTIONAL
    * */
    String SECONDARY_MOTIVATIONS_PROPERTY = "secondary_motivations";

    List<String> getSecondaryMotivations();


    /*
    * The personal reasons, motivations, or purposes of the Threat Actor regardless of organizational goals.
    *
    * Personal motivation, which is independent of the organization’s goals, describes what impels an individual to
    * carry out an attack. Personal motivation may align with the organization’s motivation—as is common with
    * activists—but more often it supports personal goals. For example, an individual analyst may join a Data Miner
    * corporation because his or her skills may align with the corporation’s objectives. But the analyst most likely
    * performs his or her daily work toward those objectives for personal reward in the form of a paycheck. The
    * motivation of personal reward may be even stronger for Threat Actors who commit illegal acts, as it is more
    * difficult for someone to cross that line purely for altruistic reasons.
    *
    * This is an open vocabulary and values SHOULD come from the attack-motivation-ov vocabulary.
    *
    * OPTIONAL
    * */
    String PERSONAL_MOTIVATIONS_PROPERTY = "personal_motivations";

    List<String> getPersonalMotivations();

}
