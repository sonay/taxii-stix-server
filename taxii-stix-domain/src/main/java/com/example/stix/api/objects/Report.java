package com.example.stix.api.objects;

import com.example.stix.api.StixType;
import com.example.stix.api.datatypes.Identifier;

import java.time.ZonedDateTime;
import java.util.List;

/*
* Type Name: report
*
* Reports are collections of threat intelligence focused on one or more topics, such as a description of a threat
* actor, malware, or attack technique, including context and related details. They are used to group related threat
* intelligence together so that it can be published as a comprehensive cyber threat story.
*
* The Report SDO contains a list of references to SDOs and SROs (the CTI datatypes included in the report) along with a
* textual description and the name of the report.
*
* For example, a threat report produced by ACME Defense Corp. discussing the Glass Gazelle campaign should be
* represented using Report. The Report itself would contain the narrative of the report while the Campaign SDO and any
* related SDOs (e.g., Indicators for the Campaign, Malware it uses, and the associated Relationships) would be
* referenced in the report contents.
* */
public interface Report extends StixDomainObject {

    /*
    * The value of this property MUST be "report".
    *
    * REQUIRED
    * */
    String TYPE = "report";

    @Override
    default StixType getType() {
        return StixType.REPORT;
    }


    /*
    * This property is an Open Vocabulary that specifies the primary subject of this report.
    *
    * This is an open vocabulary and values SHOULD come from the report-label-ov vocabulary.
    *
    * REQUIRED
    * */
    String LABELS_PROPERTY = "labels";

    List<String> getLabels();


    /*
    * A name used to identify the Report.
    *
    * REQUIRED
    * */
    String NAME_PROPERTY = "name";

    String getName();

    /*
    * The date that this Report object was officially published by the creator of this report.
    *
    * The publication date (public release, legal release, etc.) may be different than the date the report was created
    * or shared internally (the date in the created property).
    *
    * REQUIRED
    * */
    String PUBLISHED_PROPERTY = "published";

    ZonedDateTime getPublished();

    /*
    * Specifies the STIX Objects that are referred to by this Report.
    *
    * REQUIRED
    * */
    String OBJECT_REFS_PROPERTY = "object_refs";

    List<Identifier> getObjectRefs();

    /*
     * A description that provides more details and context about the Report, potentially including its purpose and its
     * key characteristics.
     *
     *
     * OPTIONAL
     * */
    String DESCRIPTION_PROPERTY = "description";

    String getDescription();

}
