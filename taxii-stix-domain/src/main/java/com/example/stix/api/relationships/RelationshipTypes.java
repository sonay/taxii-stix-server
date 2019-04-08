package com.example.stix.api.relationships;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.util.Collections.unmodifiableSet;

public interface RelationshipTypes {

    /*
    *
    */
    String DUPLICATE_OF = "duplicate-of";

    /*
     *
     */
    String DERIVED_FROM = "derived-from";

    /*
     *
     */
    String RELATED_TO = "related-to";

    /*
     *
     */
    String TARGETS= "targets";

    /*
     *
     */
    String USES = "uses";

    /*
     *
     */
    String INDICATES = "indicates";

    /*
     *
     */
    String MIGITATES = "mitigates";

    /*
     *
     */
    String ATTRIBUTED_TO = "attributed-to";

    /*
     *
     */
    String IMPERSONATES = "impersonates";

    /*
     *
     */
    String VARIANT_OF = "variant-of";

    Set<String> RELATIONSHIP_TYPES =
            unmodifiableSet(new HashSet<>(Arrays.asList(DUPLICATE_OF, DERIVED_FROM, RELATED_TO, TARGETS, USES,
                    INDICATES, MIGITATES, ATTRIBUTED_TO, IMPERSONATES, VARIANT_OF)));

    static boolean isStandard(String value) {
        return RELATIONSHIP_TYPES.contains(value);
    }

}
