package com.atlassian.jwt;

public class JwtConstants
{
    /**
     * When the JWT message is specified in the query string of a URL then this is the parameter name.
     *
     * E.g. "jwt" in:
     * <pre>
     * http://server:80/some/path?otherparam=value&amp;jwt=eyJhbGciOiJIUzI1NiIsI.eyJleHAiOjEzNzg5NCI6MTM3ODk1MjQ4OH0.cDihfcsKW_We_EY21tIs55dVwjU
     * </pre>
     */
    public static final String JWT_PARAM_NAME = "jwt";

    /**
     * The JWT spec says that implementers "MAY provide for some small leeway, usually no more than a few minutes, to account for clock skew".
     * Calculations of the current time for the purposes of accepting or rejecting time-based claims (e.g. "exp" and "nbf") will allow for the current time
     * being plus or minus this leeway, resulting in some time-based claims that are marginally before or after the current time being accepted instead of rejected.
     */
    public static final int TIME_CLAIM_LEEWAY_SECONDS = 30;

    public static final class Claims
    {
        /**
         * Instructions for computing the query hash parameter ("qsh") from a HTTP request.
         * -------------------------------------------------------------------------------------
         * Overview:       query hash = hash(canonical-request)
         *          canonical-request = canonical-method + '&amp;' + canonical-URI + '&amp;' + canonical-query-string
         * 1. Compute canonical method.
         *    Simply the upper-case of the method name (e.g. "GET", "PUT").
         * 2. Append the character '&amp;'
         * 3. Compute canonical URI.
         *    Discard the protocol, server, port, context path and query parameters from the full URL.
         *    For requests targeting add-ons discard the `baseUrl` in the add-on descriptor.
         *    (Removing the context path allows a reverse proxy to redirect incoming requests for "jira.example.com/getsomething"
         *    to "example.com/jira/getsomething" without breaking authentication. The requester cannot know that the reverse proxy
         *    will prepend the context path "/jira" to the originally requested path "/getsomething".)
         *    Empty-string is not permitted; use "/" instead.
         *    Do not suffix with a '/' character unless it is the only character.
         *    Url-encode any '&amp;' characters in the path.
         *    E.g. in "http://server:80/some/path/?param=value" the canonical URI is "/some/path"
         *     and in "http://server:80" the canonical URI is "/".
         * 4. Append the character '&amp;'.
         * 5. Compute the canonical query string.
         *    Sort the query parameters primarily by their percent-encoded names and secondarily by their percent-encoded values.
         *    Sorting is by codepoint: sort(["a", "A", "b", "B"]) =&gt; ["A", "B", "a", "b"].
         *    For each parameter append its percent-encoded name, the '=' character and then its percent-encoded value.
         *    In the case of repeated parameters append the ',' character and subsequent percent-encoded values.
         *    Ignore the {@link JwtConstants}.JWT_PARAM_NAME parameter, if present.
         *    Some particular values to be aware of: "+" is encoded as "%20",
         *                                           "*" as "%2A" and
         *                                           "~" as "~".
         *                                           (These values used for consistency with OAuth1.)
         *    An example: for a GET request to the not-yet-percent-encoded URL "http://localhost:2990/path/to/service?zee_last=param&amp;repeated=parameter 1&amp;first=param&amp;repeated=parameter 2"
         *    the canonical request is "GET&amp;/path/to/service&amp;first=param&amp;repeated=parameter%201,parameter%202&amp;zee_last=param".
         * 6. Convert the canonical request string to bytes.
         *    The encoding used to represent characters as bytes is UTF-8.
         * 7. Hash the canonical request bytes using the SHA-256 algorithm.
         *    E.g. The SHA-256 hash of "foo" is "2c26b46b68ffc68ff99b453c1d30413413422d706483bfa0f98a5e886266e7ae".
         */
        public static final String QUERY_HASH = "qsh";

        public static final String SUBJECT = "sub";
    }

    public static final class AppLinks
    {
        /**
         * The name of the property containing the unique identifier of an add-on.
         */
        public static final String ADD_ON_ID_PROPERTY_NAME = "plugin-key";

        /**
         * The name of the property containing the {@link String} value of the add-on's authentication method.
         */
        public static final String AUTH_METHOD_PROPERTY_NAME = "atlassian.auth.method";

        /**
         * The name of the property containing the shared secret used in JWT authentication (if any).
         */
        public static final String SHARED_SECRET_PROPERTY_NAME = "atlassian.jwt.shared.secret";

        /**
         * The value that the {@link #AUTH_METHOD_PROPERTY_NAME} property has if the add-on uses JWT authentication.
         */
        public static final String JWT_AUTH_METHOD_NAME = "JWT";

        /**
         * The key of the user assigned to this add-on.
         */
        public static final String ADD_ON_USER_KEY_PROPERTY_NAME = "user.key";

        /**
         * System property which determines if impersonation is allowed, by using the JWT token's <code>sub</code> claim
         */
        public static final String SYS_PROP_ALLOW_IMPERSONATION = "atlassian.jwt.impersonation.allowed";
    }

    public static final class HttpRequests
    {
        /**
         * The name of an attribute set on incoming requests by authentication filters so that later filters can discover the id of the authenticated add-on (if any).
         */
        public static final String ADD_ON_ID_ATTRIBUTE_NAME = "Plugin-Key";
        /**
         * Attribute name of where the JSON payload from the verified token is stored on incoming requests by the authentication filters
         */
        public static final String JWT_JSON_PAYLOAD_ATTRIBUTE_NAME = "jwt.payload";
        public static final String JWT_SUBJECT_ATTRIBUTE_NAME = "jwt.subject";

        public static final String AUTHORIZATION_HEADER = "Authorization";

        /**
         * The start of a valid Authorization header specifying a JWT message.<p>
         * Note the space at the end of the prefix; the header's format is:
         *  <pre>{@code
         *      JwtUtil.JWT_AUTH_HEADER_PREFIX + "<insert jwt message here>"
         *  }</pre>
         */
        public static final String JWT_AUTH_HEADER_PREFIX = "JWT ";
    }
}
