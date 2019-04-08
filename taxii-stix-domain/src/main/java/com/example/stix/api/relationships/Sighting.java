package com.example.stix.api.relationships;

import com.example.stix.api.StixType;
import com.example.stix.api.datatypes.Identifier;

import java.time.ZonedDateTime;
import java.util.List;

/*
*
* Type Name: sighting
*
* A Sighting denotes the belief that something in CTI (e.g., an indicator, malware, tool, threat actor, etc.) was seen.
* Sightings are used to track who and what are being targeted, how attacks are carried out, and to track trends in
* attack behavior.
*
* The Sighting relationship object is a special type of SRO; it is a relationship that contains extra properties not
* present on the generic Relationship object. These extra properties are included to represent data specific to
* sighting relationships (e.g., count, representing how many times something was seen), but for other purposes a
* Sighting can be thought of as a Relationship with a name of "sighting-of". Sighting is captured as a relationship
* because you cannot have a sighting unless you have something that has been sighted. Sighting does not make sense
* without the relationship to what was sighted.
*
* Sighting relationships relate three aspects of the sighting:
*
* What was sighted, such as the Indicator, Malware, Campaign, or other SDO (sighting_of_ref)
* Who sighted it and/or where it was sighted, represented as an Identity (where_sighted_refs) and
* What was actually seen on systems and networks, represented as Observed Data (observed_data_refs)
*
* What was sighted is required; a sighting does not make sense unless you say what you saw. Who sighted it, where it
* was sighted, and what was actually seen are optional. In many cases it is not necessary to provide that level of
* detail in order to provide value.
*
* Sightings are used whenever any SDO has been "seen". In some cases, the object creator wishes to convey very little
* information about the sighting; the details might be sensitive, but the fact that they saw a malware instance or
* threat actor could still be very useful. In other cases, providing the details may be helpful or even necessary;
* saying exactly which of the 1000 IP addresses in an indicator were sighted is helpful when tracking which of those
* IPs is still malicious.
*
* Sighting is distinct from Observed Data in that Sighting is an intelligence assertion ("I saw this threat actor")
* while Observed Data is simply information ("I saw this file"). When you combine them by including the linked
* Observed Data (observed_data_refs) from a Sighting, you can say "I saw this file, and that makes me think I saw
* this threat actor". Although confidence is currently reserved, notionally confidence would be added to Sighting
* (the intelligence relationship) but not to Observed Data (the raw information).
* */
public interface Sighting extends StixRelationshipObject {

    String TYPE = "sighting";

    /*
    * The value of this property MUST be "sighting".
    *
    * REQUIRED
    * */
    default StixType getType() {
        return StixType.SIGHTING;
    }


    /*
     * An ID reference to the SDO that was sighted (e.g., Indicator or Malware).
     *
     * For example, if this is a Sighting of an Indicator, that Indicator’s ID would be the value of this property.
     *
     * This property MUST reference only an SDO or a Custom Object.
     *
     * REQUIRED
     * */
    String SIGHTING_OF_REF_PROPERTY = "sighting_of_ref";

    Identifier getSightingOfRef();

    /*
    * The beginning of the time window during which the SDO referenced by the sighting_of_ref property was sighted.
    *
    * OPTIONAL
    * */
    String FIRST_SEEN_PROPERTY = "first_seen";

    ZonedDateTime getFirstSeen();

    /*
    * The end of the time window during which the SDO referenced by the sighting_of_ref property was sighted.
    *
    * OPTIONAL
    * */
    String LAST_SEEN_PROPERTY = "last_seen";

    ZonedDateTime getLastSeen();

    /*
    * This MUST be an integer between 0 and 999,999,999 inclusive and represents the number of times the SDO referenced by the sighting_of_ref property was sighted.
    *
    * Observed Data has a similar property called number_observed, which refers to the number of times the data was
    * observed. These counts refer to different concepts and are distinct.
    *
    * For example, a single sighting of a DDoS bot might have many millions of observations of the network traffic
    * that it generates. Thus, the Sighting count would be 1 (the bot was observed once) but the Observed Data
    * number_observed would be much higher.
    *
    * As another example, a sighting with a count of 0 can be used to express that an indicator was not seen at all.
    *
    * OPTIONAL
    * */
    String COUNT_PROPERTY = "count";

    Integer getCount();

    /*
    * A list of ID references to the Observed Data datatypes that contain the raw cyber data for this Sighting.
    *
    * For example, a Sighting of an Indicator with an IP address could include the Observed Data for the network connection that the Indicator was used to detect.
    *
    * This property MUST reference only Observed Data SDOs.
    *
    * OPTIONAL
    * */
    String OBSERVED_DATA_REFS_PROPERTY = "observed_data_refs";

    List<Identifier> getObservedDataRefs();

    /*
    * A list of ID references to the Identity (victim) datatypes of the entities that saw the sighting.
    *
    * Omitting the where_sighted_refs property does not imply that the sighting was seen by the object creator. To
    * indicate that the sighting was seen by the object creator, an Identity representing the object creator should be listed in where_sighted_refs.
    *
    * This property MUST reference only Identity SDOs.
    * */
    String WHERE_SIGHTED_REFS_PROPERTY = "where_sighted_refs";

    List<Identifier> getWhereSightedRefs();

    /*
    * The summary property indicates whether the Sighting should be considered summary data. Summary data is an
    * aggregation of previous Sightings reports and should not be considered primary source data. Default value is
    * false.
    *
    * OPTIONAL
    * */
    String SUMMARY_PROPERTY = "summary";

    Boolean isSummary();

}
