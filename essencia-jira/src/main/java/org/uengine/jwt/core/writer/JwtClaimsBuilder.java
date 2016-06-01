package org.uengine.jwt.core.writer;

import org.uengine.jwt.CanonicalHttpRequest;
import org.uengine.jwt.core.HttpRequestCanonicalizer;
import org.uengine.jwt.writer.JwtJsonBuilder;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class JwtClaimsBuilder
{
    /**
     * Convenience method for building and appending JWT claims related to a {@link org.uengine.jwt.CanonicalHttpRequest}.
     * Encapsulates the knowledge of what claims we make regarding the request.
     * @param jsonBuilder {@link org.uengine.jwt.writer.JwtJsonBuilder} that constructs the JWT payload
     * @param request {@link org.uengine.jwt.CanonicalHttpRequest} representing the incoming or outgoing HTTP request
     * @throws UnsupportedEncodingException if {@link java.net.URLEncoder} cannot encode the request's characters
     * @throws NoSuchAlgorithmException if the hashing algorithm does not exist at runtime
     */
    public static void appendHttpRequestClaims(JwtJsonBuilder jsonBuilder, CanonicalHttpRequest request) throws UnsupportedEncodingException, NoSuchAlgorithmException
    {
        jsonBuilder.queryHash(HttpRequestCanonicalizer.computeCanonicalRequestHash(request));
    }
}
