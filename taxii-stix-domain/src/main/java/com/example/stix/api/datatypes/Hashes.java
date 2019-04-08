package com.example.stix.api.datatypes;


/*
* Type Name: hashes
*
* The Hashes type represents 1 or more cryptographic hashes, as a special set of key/value pairs. Accordingly, the
* name of each hashing algorithm MUST be specified as a key in the dictionary and MUST identify the name of the
* hashing algorithm used to generate the corresponding value. This name SHOULD either be one of the values defined
* in the hash-algorithm-ov OR a custom value prepended with “x_” (e.g., “x_custom_hash”).
*
* Keys MUST be unique in each hashes property, MUST be in ASCII, and are limited to the characters a-z (lowercase
* ASCII), A-Z (uppercase ASCII), numerals 0-9, hyphen (-), and underscore (_). Keys SHOULD be no longer than 30
* ASCII characters in length, MUST have a minimum length of 3 ASCII characters, MUST be no longer than 256 ASCII
* characters in length.
* */

public interface Hashes {


    /* NOT USED, Map<String, String> does the job, JUST HERE FOR DOCUMENTATION PURPOSES  */

}
