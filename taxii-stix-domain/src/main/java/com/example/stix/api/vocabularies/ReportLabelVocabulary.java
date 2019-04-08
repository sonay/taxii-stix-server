package com.example.stix.api.vocabularies;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.util.Collections.unmodifiableSet;

/*
* Vocabulary Name: report-label-ov
*
* The report label vocabulary is currently used in the following SDO(s):
*
*    Report
*
* Report label is an open vocabulary to describe the primary purpose or subject of a report. For example, a report
* that contains malware and indicators for that malware should have a report label of malware to capture that the
* malware is the primary purpose. Report labels are not mutually exclusive: a Report can be both a malware report
* and a tool report. Just because a report contains datatypes of a type does not mean that the report should include
* that label.  If the datatypes are there to simply provide evidence or context for other datatypes, it is not necessary
* to include them in the label.
* */
public interface ReportLabelVocabulary {

    /*
    * Report subject is a broad characterization of a threat across multiple facets.
    * */
    String THREAT_REPORT = "threat-report";

    /*
     * Report subject is a characterization of one or more attack patterns and related information.
     * */
    String ATTACK_PATTERN = "attack-pattern";

    /*
     * Report subject is a characterization of one or more campaigns and related information.
     * */
    String CAMPAIGN = "campaign";

    /*
     * Report subject is a characterization of one or more identities and related information.
     * */
    String IDENTITY = "identity";

    /*
     * Report subject is a characterization of one or more indicators and related information.
     * */
    String INDICATOR = "indicator";

    /*
     * Report subject is a characterization of one or more intrusion sets and related information.
     * */
    String INTRUSION_SET = "intrusion-set";

    /*
     * Report subject is a characterization of one or more malware instances and related information.
     * */
    String MALWARE = "malware";

    /*
     * Report subject is a characterization of observed data and related information.
     * */
    String OBSERVED_DATA = "observed-data";

    /*
     * Report subject is a characterization of one or more threat actors and related information.
     * */
    String THREAT_ACTOR = "threat-actor";

    /*
     * Report subject is a characterization of one or more tools and related information.
     * */
    String TOOL = "tool";

    /*
     * Report subject is a characterization of one or more vulnerabilities and related information.
     * */
    String VULNERABILITY = "vulnerability";

    Set<String> REPORT_LABEL_OPEN_VOCABULARY =
            unmodifiableSet(new HashSet<>(Arrays.asList(THREAT_REPORT, ATTACK_PATTERN, CAMPAIGN, IDENTITY, INDICATOR,
                    INTRUSION_SET, MALWARE, OBSERVED_DATA, THREAT_ACTOR, TOOL, VULNERABILITY
            )));

    static boolean isStandard(String value) {
        return REPORT_LABEL_OPEN_VOCABULARY.contains(value);
    }

}
