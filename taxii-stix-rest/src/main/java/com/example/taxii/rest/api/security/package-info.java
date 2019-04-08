package com.example.taxii.rest.api.security;

/*
 * Authentication and Authorization in TAXII is implemented as defined in [RFC7235], using the Authorization and
 * WWW-Authenticate HTTP headers respectively.
 *
 * HTTP Basic authentication, as defined in [RFC7617] is the mandatory to implement authentication scheme in TAXII.
 * As specified in sections 8.2.2 and 8.5.1, TAXII Servers and Clients are required to implement support for HTTP
 * Basic, though other authentication schemes can also be supported. Implementers can allow operators to disable the
 * use of HTTP Basic in their operation
 *
 * If the TAXII Server receives a request for any Endpoint that requires authentication, regardless of HTTP method,
 * and either an acceptable Authorization header that grants the client access to that object is not sent with the
 * request or the TAXII Server does not determine via alternate means that the client is authorized to access the
 * resource, the TAXII Server responds with a HTTP 401 (Unauthorized) status code and a WWW-Authenticate HTTP header.
 *
 * The WWW-Authenticate header contains one or more challenges, which define which authentication schemes are
 * supported by the TAXII Server. The format of the WWW-Authenticate HTTP header and any challenges are defined in
 * [RFC7235]. To ensure compatibility, it is recommended that any authentication schemes used in challenges be
 * registered in the IANA Hypertext Transfer Protocol (HTTP) Authentication Scheme Registry [HTTP Auth] .
 *
 * A TAXII Server may omit objects, information, or optional fields from any response if the authenticated client is
 * not authorized to receive them, so long as that omission does not violate this specification.
 *
 * */