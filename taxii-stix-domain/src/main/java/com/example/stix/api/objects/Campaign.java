package com.example.stix.api.objects;

import com.example.stix.api.StixType;

import java.time.ZonedDateTime;
import java.util.List;

/*
* Type Name: campaign
*
* A Campaign is a grouping of adversarial behaviors that describes a set of malicious activities or attacks (sometimes
* called waves) that occur over a period of time against a specific set of targets. Campaigns usually have well
* defined
* objectives and may be part of an Intrusion Set.
*
* Campaigns are often attributed to an intrusion set and threat actors. The threat actors may reuse known
* infrastructure from the intrusion set or may set up new infrastructure specific for conducting that campaign.
*
* Campaigns can be characterized by their objectives and the incidents they cause, people or resources they target,
* and the resources (infrastructure, intelligence, Malware, Tools, etc.) they use.
*
* For example, a Campaign could be used to describe a crime syndicate's attack using a specific variant of malware and
* new C2 servers against the executives of ACME Bank during the summer of 2016 in order to gain secret information
* about an upcoming merger with another bank.
* */
public interface Campaign extends StixDomainObject {

    /*
    * The value of this property MUST be "campaign".
    *
    * REQUIRED
    * */
    String TYPE = "campaign";

    @Override
    default StixType getType() {
        return StixType.CAMPAIGN;
    }


    /*
    * A name used to identify the Campaign.
    *
    * REQUIRED
    * */
    String NAME_PROPERTY = "name";

    String getName();


    /*
    * A description that provides more details and context about the Campaign, potentially including its purpose and
    * its key characteristics.
    *
    * OPTIONAL
    * */
    String DESCRIPTION_PROPERTY = "description";

    String getDescription();


    /*
    * Alternative names used to identify this Campaign
    *
    * OPTIONAL
    * */
    String ALIASES_PROPERTY = "aliases";

    List<String> getAliases();


    /*
    * The time that this Campaign was first seen. 
    * 
    * This property is a summary property of data from sightings and other data that may or may not be available in 
    * STIX. If new sightings are received that are earlier than the first seen timestamp, the object may be updated 
    * to account for the new data.
    *
    * OPTIONAL
    * */
    String FIRST_SEEN_PROPERTY = "first_seen";

    ZonedDateTime getFirstSeen();


    /*
    * The time that this Campaign was last seen.
    * 
    * This property is a summary property of data from sightings and other data that may or may not be available in 
    * STIX. If new sightings are received that are later than the last seen timestamp, the object may be updated to 
    * account for the new data.
    * 
    * OPTIONAL
    * */
    String LAST_SEEN_PROPERTY = "last_seen";

    ZonedDateTime getLastSeen();


    /*
    * This property defines the Campaign’s primary goal, objective, desired outcome, or intended effect — what the
    * Threat Actor hopes to accomplish with this Campaign.
    *
    * OPTIONAL
    * */
    String OBJECTIVE_PROPERTY = "objective";

    String getObjective();

}
