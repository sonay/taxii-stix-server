package com.example.stix.api.objects;

import com.example.stix.api.StixType;

import java.util.List;

/*
* Type Name: identity
*
* Identities can represent actual individuals, organizations, or groups (e.g., ACME, Inc.) as well as classes of
* individuals, organizations, or groups (e.g., the finance sector).
*
* The Identity SDO can capture basic identifying information, contact information, and the sectors that the Identity
* belongs to. Identity is used in STIX to represent, among other things, targets of attacks, information sources, object
* creators, and threat actor identities.
*
* */
public interface Identity extends StixDomainObject {

    /*
    * The value of this property MUST be "identity".
    *
    * REQUIRED
    * */
    String TYPE = "identity";

    @Override
    default StixType getType() {
        return StixType.IDENTITY;
    }


    /*
     * The name of this Identity. When referring to a specific entity (e.g., an individual or organization), this
     * property SHOULD contain the canonical name of the specific entity.
     *
     * REQUIRED
     * */
    String NAME_PROPERTY = "name";

    String getName();


    /*
     * The type of entity that this Identity describes, e.g., an individual or organization.
     *
     * This is an open vocabulary and the values SHOULD come from the identity-class-ov vocabulary.
     *
     * REQUIRED
     * */
    String IDENTITY_CLASS_PROPERTY = "identity_class";

    String getIdentityClass();


    /*
    * The list of roles that this Identity performs (e.g., CEO, Domain Administrators, Doctors, Hospital, or Retailer).
    * No open vocabulary is yet defined for this property.
    *
    * OPTIONAL
    * */
    String LABELS_PROPERTY = "labels";

    @Override
    List<String> getLabels();


    /*
    * A description that provides more details and context about the Identity, potentially including its purpose and its
    * key characteristics.
    *
    * OPTIONAL
    * */
    String DESCRIPTION_PROPERTY = "description";

    String getDescription();


    /*
    * The list of industry sectors that this Identity belongs to.
    * This is an open vocabulary and values SHOULD come from the industry-sector-ov vocabulary.
    *
    * OPTIONAL
    * */
    String SECTORS_PROPERTY = "sectors";

    List<String> getSectors();


    /*
    * The contact information (e-mail, phone number, etc.) for this Identity.  No format for this information is
    * currently defined by this specification.
    *
    * OPTIONAL
    * */
    String CONTACT_INFORMATION_PROPERTY = "contact_information";

    String getContactInformation();

}
