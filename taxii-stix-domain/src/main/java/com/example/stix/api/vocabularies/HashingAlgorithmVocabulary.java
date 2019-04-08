package com.example.stix.api.vocabularies;

import com.example.stix.api.datatypes.OpenVocabulary;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.util.Collections.unmodifiableSet;

/*
* Vocabulary Name: hash-algorithm-ov
*
* An open vocabulary of hashing algorithms.
*
* When specifying a hashing algorithm not already defined within the hash-algorithm-ov, wherever an authoritative name
* for a hashing algorithm name is defined, it should be used as the value. In cases where no authoritative name
* exists and/or where there is variance in the naming of a particular hashing algorithm, producers should exercise
* their best judgement.
*
* */
public interface HashingAlgorithmVocabulary extends OpenVocabulary {

    /*
    * Specifies the MD5 message digest algorithm. The corresponding hash string for this value MUST be a valid MD5
    * message digest as defined in [RFC 1321].
    */
    String MD5 = "MD5";

    /*
     * Specifies the MD6 message digest algorithm. The corresponding hash string for this value MUST be a valid MD6
     * message digest as defined in the [MD6] proposal.
     */
    String MD6 = "MD6";

    /*
     * Specifies the RIPEMD­-160 (R​ACE​ Integrity Primitives Evaluation Message Digest)​ cryptographic hash function.
     * The corresponding hash string for this value MUST be a valid RIPEMD-160 message digest as defined in the
     * [RIPEMD-160] specification.
     */
    String RIPEMD_160 = "RIPEMD-160";

    /*
     * Specifies the SHA­-1 (secure-­hash algorithm 1) cryptographic hash function. The corresponding hash string
     * for this value MUST be a valid SHA-1 message digest as defined in [RFC 3174].
     */
    String SHA_1 = "SHA-1";

    /*
     * Specifies the SHA-­224 cryptographic hash function (part of the SHA­2 family). The corresponding hash string
     * for this value MUST be a valid SHA-224 message digest as defined in [RFC 6234].
     */
    String SHA_224 = "SHA-224";

    /*
     * Specifies the SHA-­256 cryptographic hash function (part of the SHA­2 family). The corresponding hash string
     * for this value MUST be a valid SHA-256 message digest as defined in [RFC 6234].
     */
    String SHA_256 = "SHA-256";

    /*
     * Specifies the SHA-­384 cryptographic hash function (part of the SHA­2 family). The corresponding hash string
     * for this value MUST be a valid SHA-384 message digest as defined in [RFC 6234].
     */
    String SHA_384 = "SHA-384";

    /*
     * Specifies the SHA-­512 cryptographic hash function (part of the SHA­2 family). The corresponding hash string
     * for this value MUST be a valid SHA-512 message digest as defined in [RFC 6234].
     */
    String SHA_512 = "SHA-512";

    /*
     * Specifies the SHA3-224 cryptographic hash function. The corresponding hash string for this value MUST be a
     * valid SHA3-224 message digest as defined in [FIPS202].
     */
    String SHA3_224 = "SHA3-224";

    /*
     * Specifies the SHA3-256 cryptographic hash function. The corresponding hash string for this value MUST be a
     * valid SHA3-256 message digest as defined in [FIPS202].
     */
    String SHA3_256 = "SHA3-256";

    /*
     * Specifies the SHA3-384 cryptographic hash function. The corresponding hash string for this value MUST be a
     * valid SHA3-384 message digest as defined in [FIPS202].
     */
    String SHA3_384 = "SHA3-384";

    /*
     * Specifies the SHA3-512 cryptographic hash function. The corresponding hash string for this value MUST be a
     * valid SHA3-512 message digest as defined in [FIPS202].
     */
    String SHA3_512 = "SHA3-512";

    /*
     * Specifies the ssdeep fuzzy hashing algorithm. The corresponding hash string for this value MUST be a valid
     * piecewise hash as defined in the [SSDEEP] specification.
     */
    String SSDEEP = "ssdeep";

    /*
     * Specifies the whirlpool cryptographic hash function. The corresponding hash string for this value MUST be a
     * valid WHIRLPOOL message digest as defined in [ISO10118].
     */
    String WHIRLPOOL = "WHIRLPOOL";

    Set<String> HASHING_ALGORITHM_OPEN_VOCABULARY =
            unmodifiableSet(new HashSet<>(Arrays.asList(MD5, MD6, RIPEMD_160, SHA_1, SHA_224, SHA_256, SHA_384,
                    SHA_512, SHA3_224, SHA3_256, SHA3_384, SHA3_512, SSDEEP, WHIRLPOOL)));

    static boolean isStandard(String value) {
        return HASHING_ALGORITHM_OPEN_VOCABULARY.contains(value);
    }

}
