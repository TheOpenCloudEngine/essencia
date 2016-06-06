package org.uengine.jwt.core.reader;

import org.uengine.jwt.CanonicalHttpRequest;
import org.uengine.jwt.JwtConstants;
import org.uengine.jwt.core.HttpRequestCanonicalizer;
import org.uengine.jwt.reader.JwtClaimVerifier;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Map;

public class JwtClaimVerifiersBuilder
{
    /**
     * Tell {@link org.uengine.jwt.reader.JwtReader}.readAndVerify() that no custom claims are mandatory.
     */
    public static final Map<String, JwtClaimVerifier> NO_REQUIRED_CLAIMS = Collections.emptyMap();

    /**
     * Encapsulate the building of requirements that we place upon JWTs in incoming requests.
     * @param request incoming request
     * @return {@link Map} of claim name to verifier for claims upon which we place requirements
     * @throws UnsupportedEncodingException if {@link java.net.URLEncoder} cannot encode the request's characters
     * @throws NoSuchAlgorithmException if the hashing algorithm does not exist at runtime
     */
    public static Map<String, ? extends JwtClaimVerifier> build(CanonicalHttpRequest request) throws UnsupportedEncodingException, NoSuchAlgorithmException
    {
        return Collections.singletonMap(JwtConstants.Claims.QUERY_HASH,
                new JwtClaimEqualityVerifier(JwtConstants.Claims.QUERY_HASH, HttpRequestCanonicalizer.computeCanonicalRequestHash(request)));
    }
}
