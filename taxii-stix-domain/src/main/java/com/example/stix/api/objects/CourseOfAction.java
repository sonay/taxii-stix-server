package com.example.stix.api.objects;

import com.example.stix.api.StixType;

/*
* Type Name: course-of-action
*
* Note: The Course of Action object in STIX 2.0 is a stub. It is included to support basic use cases (such as sharing
* prose courses of action) but does not support the ability to represent automated courses of action or contain
* properties to represent metadata about courses of action. Future STIX 2 releases will expand it to include these
* capabilities.
*
* A Course of Action is an action taken either to prevent an attack or to respond to an attack that is in progress.
* It may describe technical, automatable responses (applying patches, reconfiguring firewalls) but can also describe
* higher level actions like employee training or policy changes. For example, a course of action to mitigate a
* vulnerability could describe applying the patch that fixes it.
*
* The Course of Action SDO contains a textual description of the action; a reserved action property also serves as
* placeholder for future inclusion of machine automatable courses of action. Relationships from the Course of Action
* can be used to link it to the Vulnerabilities or behaviors (Tool, Malware, Attack Pattern) that it mitigates.
*
* */
public interface CourseOfAction extends StixDomainObject {

    /*
    * The value of this property MUST be "course-of-action".
    *
    * REQUIRED
    * */
    String TYPE = "course-of-action";

    @Override
    default StixType getType() {
        return StixType.COURSE_OF_ACTION;
    }


    /*
    * A name used to identify the Course of Action.
    *
    * REQUIRED
    * */
    String NAME_PROPERTY = "name";

    String getName();


    /*
    * A description that provides more details and context about the Course of Action, potentially including its purpose
    * and its key characteristics.
    *
    * OPTIONAL
    * */
    String DESCRIPTION_PROPERTY = "description";

    String getDescription();


    /*
    * RESERVED – To capture structured/automated courses of action.
    * */
    // RESERVED getAction();

}
