package com.example.stix.api.datatypes;

/*
* Type Name: open-vocab
*
* The open-vocab type is represented as a string. For properties that use this type there will be a list of suggested
* values, known as the suggested vocabulary, that is identified in the definition for that property. The suggested
* vocabularies are defined in section 6. The value of the property SHOULD be chosen from the suggested vocabulary
* but MAY be any other string value. Values that are not from the suggested vocabulary SHOULD be all lowercase
* (where lowercase is defined by the locality conventions) and SHOULD use hyphens instead of spaces or underscores
* as word separators.
*
* A consumer that receives STIX content with one or more open-vocab terms not defined in the suggested vocabulary MAY
* ignore those values.
*
* The JSON MTI serialization uses the JSON string type [RFC7159] when representing open-vocab.
*
* */
public interface OpenVocabulary {

    /* NOT USED (String does the job) JUST HERE FOR DOCUMENTATION PURPOSES  */

}
