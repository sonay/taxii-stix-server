package com.example.stix.api.objects;

import com.example.stix.api.StixType;

import java.time.ZonedDateTime;

/*
* Type Name: observed-data
*
* Observed Data conveys information that was observed on systems and networks using the Cyber Observable specification
* defined in parts 3 and 4 of this specification. For example, Observed Data can capture the observation of an IP
* address, a network connection, a file, or a registry key. Observed Data is not an intelligence assertion, it is simply
* information: this file was seen, without any context for what it means.
*
* Observed Data captures both a single observation of a single entity (file, network connection) as well as the
* aggregation of multiple observations of an entity. When the number_observed property is 1 the Observed Data is of a
* single entity. When the number_observed property is greater than 1, the observed data consists of several instances of
* an entity collected over the time window specified by the first_observed and last_observed properties. When used to
* collect aggregate data, it is likely that some fields in the Cyber Observable Object (e.g., timestamp fields) will be
* omitted because they would differ for each of the individual observations.
*
* Observed Data may be used by itself (without relationships) to convey raw data collected from network and host-based
* detection tools. A firewall could emit a single Observed Data instance containing a single Network Traffic object for
* each connection it sees. The firewall could also aggregate data and instead send out an Observed Data instance every
* ten minutes with an IP address and an appropriate number_observed value to indicate the number of times that IP
* address was observed in that window.
*
* Observed Data may also be related to other SDOs to represent raw data that is relevant to those datatypes. The Sighting
* object, which captures the sighting of an Indicator, Malware, or other SDO, uses Observed Data to represent the raw
* information that led to the creation of the Sighting (e.g., what was actually seen that suggested that a particular
* instance of malware was active).
* */
public interface ObservedData extends StixDomainObject {

    /*
    * The value of this property MUST be "observed-data".
    *
    * REQUIRED
    * */
    String TYPE = "observed-data";

    @Override
    default StixType getType() {
        return StixType.OBSERVED_DATA;
    }


    /*
    * The beginning of the time window during which the data was observed.
    *
    * REQUIRED
    * */
    String FIRST_OBSERVED_PROPERTY = "first_observed";

    ZonedDateTime getFirstObserved();


    /*
    * The end of the time window during which the data was observed.
    *
    * REQUIRED
    * */
    String LAST_OBSERVED_PROPERTY = "last_observed";

    ZonedDateTime getLastObserved();

    /*
    * The number of times the data represented in the datatypes property was observed. This MUST be an integer between 1
    * and 999,999,999 inclusive.
    *
    * If the number_observed property is greater than 1, the data contained in the datatypes property was observed
    * multiple times. In these cases, object creators MAY omit properties of the Cyber Observable object (such as
    * timestamps) that are specific to a single instance of that observed data.
    *
    * REQUIRED
    * */
    String NUMBER_OBSERVED_PROPERTY = "number_observed";

    int getNumberObserved();


    int MIN_OBSERVED = 1;

    int MAX_OBSERVED = 999_999_999;

    /*
    * A dictionary of Cyber Observable Objects representing the observation. The dictionary MUST contain at least one
    * object. The observable-datatypes type is defined in STIX™ Version 2.0. Part 3: Cyber Observable Core Concepts.
    *
    * The Cyber Observable content MAY include multiple datatypes if those datatypes are related as part of a single
    * observation. Multiple datatypes not related to each other via Cyber Observable Relationships MUST NOT be
    * contained within the same Observed Data instance.
    *
    * For example, a Network Traffic object and two IPv4 Address datatypes related via the src_ref and dst_ref properties
    * can be contained in the same Observed Data because they are all related and used to characterize that single
    * entity. Two unrelated IPv4 address datatypes that just happened to be observed at the same time, however, must be
    * represented in separate Observed Data instances.
    *
    * REQUIRED
    * */
    String OBJECTS_PROPERTY = "objects";

    ObservableObjects getObjects();

}
